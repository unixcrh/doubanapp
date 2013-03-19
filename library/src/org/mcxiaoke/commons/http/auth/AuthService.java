package org.mcxiaoke.commons.http.auth;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.protocol.HTTP;
import org.mcxiaoke.commons.http.SimpleRequest;
import org.mcxiaoke.commons.http.auth.AuthConstants.OAuthParameterStyle;
import org.mcxiaoke.commons.http.impl.Parameter;
import org.mcxiaoke.commons.http.util.URIUtilsEx;
import org.mcxiaoke.commons.util.Base64;
import org.mcxiaoke.commons.util.StringUtils;

/**
 * @author mcxiaoke
 * 
 */
public final class AuthService {
	private final static Random RAND = new Random();
	private static final String PARAMETER_SEPARATOR = "&";
	private static final String NAME_VALUE_SEPARATOR = "=";
	private static final String EMPTY_STRING = "";
	private static final String OAUTH_SCHEME = "OAuth";
	private static final String OAUTH2_SCHEME = "Bear";
	private static final String BASIC_SCHEME = "Basic";

	private final AuthConfig mOAuthConfig;

	private AuthService(AuthConfig config) {
		this.mOAuthConfig = config;
	}

	public AuthConfig getOAuthConfig() {
		return mOAuthConfig;
	}

	public static void authorize(final SimpleRequest request) {
		final AuthConfig authorization = request.getAuthConfig();
		if (request == null || authorization == null
				|| !authorization.isAuthorized()) {
			return;
		}
		int type = authorization.getAuthType();
		if (type == AuthConfig.BASIC) {
			addBasicAuthToHeaders(request);
		} else if (type == AuthConfig.OAUTH1) {
			final OAuthParameterStyle style = authorization
					.getOAuthParameterStyle();
			if (style == OAuthParameterStyle.QUERY_STRING) {
				addOAuthToQueryParamters(request);
			} else {
				addOAuthToHeaders(request);
			}
		} else if (type == AuthConfig.OAUTH2) {
			final OAuthParameterStyle style = authorization
					.getOAuthParameterStyle();
			if (style == OAuthParameterStyle.QUERY_STRING) {
				addOAuth2ToQueryParamters(request);
			} else {
				addOAuth2ToHeaders(request);
			}
		}
	}

	private static void addOAuthToQueryParamters(final SimpleRequest request) {
		addOAuthParameters(request);
		appendAuthorizationToQueryParameters(request);
	}

	private static void addOAuth2ToQueryParamters(final SimpleRequest request) {
		String accessToken = request.getAuthConfig().getAccessToken();
		request.addQueryParameter(AuthConstants.OAUTH2_ACCESS_TOKEN,
				accessToken);
	}

	private static void addOAuthToHeaders(final SimpleRequest request) {
		addOAuthParameters(request);
		appendAuthorizationToHeaders(request);
	}

	private static void addOAuth2ToHeaders(final SimpleRequest request) {
		String accessToken = request.getAuthConfig().getAccessToken();
		StringBuilder sb = new StringBuilder();
		sb.append(OAUTH2_SCHEME).append(" ").append(accessToken);
		request.addHeader(AuthConstants.HEADER, sb.toString());
	}

	private static void addBasicAuthToHeaders(final SimpleRequest request) {
		final AuthConfig authorization = request.getAuthConfig();
		if (request == null || authorization == null
				|| !authorization.isAuthorized()) {
			return;
		}
		String userName = authorization.getAccessToken();
		String password = authorization.getAccessTokenSecret();
		StringBuilder sb = new StringBuilder();
		sb.append(BASIC_SCHEME).append(" ");
		sb.append(userName).append(NAME_VALUE_SEPARATOR).append(password);
		String basicHeader = Base64.encodeBytes(getBytes(sb.toString()));
		request.addHeader(AuthConstants.HEADER, basicHeader);

	}

	private static void appendAuthorizationToQueryParameters(
			final SimpleRequest request) {
		request.addQueryParameters(request.getOAuthParameters());
	}

	private static void appendAuthorizationToHeaders(final SimpleRequest request) {
		request.addHeader(AuthConstants.HEADER,
				getAuthorizationHeader(request.getOAuthParametersMap()));
	}

	private static String getAuthorizationHeader(
			final Map<String, String> authParameters) {
		StringBuilder sb = new StringBuilder();
		if (authParameters != null) {
			for (Map.Entry<String, String> parameter : authParameters
					.entrySet()) {
				if (sb.length() > 0)
					sb.append(",");
				sb.append(" ");
				sb.append(percentEncode(parameter.getKey())).append("=\"");
				sb.append(percentEncode(parameter.getValue())).append('"');
			}
		}
		sb.insert(0, OAUTH_SCHEME);
		return sb.toString();
	}

	private static void addOAuthParameters(final SimpleRequest request) {
		// 这两者有先后顺序，签名生成依赖于添加的OAuthParameters
		request.addOAuthParameters(createOAuthParameters(request
				.getAuthConfig()));
		request.addOAuthParameter(AuthConstants.OAUTH_SIGNATURE,
				getSignature(request));
	}

	private static String getSignature(final SimpleRequest request) {
		final AuthConfig authorization = request.getAuthConfig();
		String baseString = getBaseString(request);
		SecretKeySpec secretKey = getSecretKeySpec(
				authorization.getApiSecret(),
				authorization.getAccessTokenSecret());
		return signature(baseString, secretKey);
	}

	private static String signature(final String data, final SecretKeySpec spec) {
		byte[] byteHMAC = null;
		try {
			Mac mac = Mac.getInstance(AuthConstants.HMAC_SHA1);
			mac.init(spec);
			byteHMAC = mac.doFinal(data.getBytes());
		} catch (InvalidKeyException ike) {
			throw new AssertionError(ike);
		} catch (NoSuchAlgorithmException nsae) {
			throw new AssertionError(nsae);
		}
		return Base64.encodeBytes(byteHMAC);
	}

	private static SecretKeySpec getSecretKeySpec(final String consumerSecret,
			final String accessTokenSecret) {
		if (StringUtils.isEmpty(accessTokenSecret)) {
			String oauthSignature = percentEncode(consumerSecret) + "&";
			return new SecretKeySpec(oauthSignature.getBytes(),
					AuthConstants.HMAC_SHA1);
		} else {
			String oauthSignature = percentEncode(consumerSecret) + "&"
					+ percentEncode(accessTokenSecret);
			return new SecretKeySpec(oauthSignature.getBytes(),
					AuthConstants.HMAC_SHA1);
		}
	}

	private static String getBaseString(final SimpleRequest request) {
		StringBuilder sb = new StringBuilder();
		final String url = request.getUrl();
		String encodedUrl = percentEncode(url);
		final String method = request.getMethodName();
		String encodedMethod = percentEncode(method);
		List<Parameter> allParameters = new ArrayList<Parameter>();
		allParameters.addAll(request.getParameters());
		allParameters.addAll(request.getQueryParameters());
		allParameters.addAll(request.getOAuthParameters());
		final String encodedParameters = getSortedAndEncodedParametersAsString(allParameters);
		sb.append(encodedUrl).append("&").append(encodedMethod).append("&")
				.append(encodedParameters);
		return sb.toString();
	}

	private static String getSortedAndEncodedParametersAsString(
			final List<Parameter> parameters) {
		if (parameters == null || parameters.size() == 0) {
			return EMPTY_STRING;
		}
		ArrayList<Parameter> queryParameters = new ArrayList<Parameter>(
				parameters);
		Collections.sort(queryParameters);
		StringBuilder sb = new StringBuilder();
		for (Parameter pair : queryParameters) {
			sb.append(PARAMETER_SEPARATOR).append(pair.getEncoded());
		}
		return sb.substring(1).toString();
	}

	private static Map<String, String> createOAuthParameters(
			final AuthConfig authorization) {
		AuthConfig auth = authorization;
		final Map<String, String> oauthParamters = new HashMap<String, String>();
		if (auth != null) {
			long timestamp = System.currentTimeMillis() / 1000;
			long nonce = timestamp + RAND.nextInt();
			if (StringUtils.isNotEmpty(auth.getAccessToken())) {
				oauthParamters.put(AuthConstants.OAUTH_TOKEN,
						auth.getAccessToken());
			}
			oauthParamters.put(AuthConstants.OAUTH_CONSUMER_KEY,
					auth.getApiKey());
			oauthParamters.put(AuthConstants.OAUTH_SIGNATURE_METHOD,
					AuthConstants.HMAC_SHA1);
			oauthParamters.put(AuthConstants.OAUTH_TIMESTAMP,
					String.valueOf(timestamp));
			oauthParamters.put(AuthConstants.OAUTH_NONCE,
					String.valueOf(nonce));
			oauthParamters.put(AuthConstants.OAUTH_VERSION,
					AuthConstants.VERSION_1_0);
		}
		return oauthParamters;
	}

	private static byte[] getBytes(String text) {
		if (text == null) {
			return null;
		}
		try {
			return text.getBytes(HTTP.UTF_8);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private static String percentEncode(String text) {
		if (text == null) {
			return EMPTY_STRING;
		}
		return URIUtilsEx.percentEncode(text);
	}

}