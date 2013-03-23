/**
 * 
 */
package org.mcxiaoke.douban;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.mcxiaoke.commons.auth.Authorization;
import org.mcxiaoke.commons.auth.SignatureStyle;
import org.mcxiaoke.commons.http.HttpMethod;
import org.mcxiaoke.commons.http.RequestBuilder;
import org.mcxiaoke.commons.http.SimpleClient;
import org.mcxiaoke.commons.http.SimpleRequest;
import org.mcxiaoke.commons.http.SimpleResponse;
import org.mcxiaoke.commons.util.AssertUtils;
import org.scribe.model.OAuthToken;

import android.content.Context;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanClientImpl implements DoubanClient {
	private Context mContext;
	private SimpleClient mClient;
	private DoubanSession mSession;

	// private oauthc

	public DoubanClientImpl(Context context, DoubanSession session) {
		AssertUtils.notNull(context,
				"context must not be null, suggested use ApplicationContext.");
		AssertUtils.notNull(session, "session must not be null.");
		this.mContext = context.getApplicationContext();
		this.mClient = new SimpleClient(this.mContext);
		this.mSession = session;
	}

	@Override
	public String getAuthorizeUrl() {
		return mSession.getAuthorizeUrl();
	}

	@Override
	public OAuthToken getAccessTokenByCode(String authorizeCode) {
		return mSession.getAccessTokenByCode();
	}

	@Override
	public OAuthToken getAccessTokenByCredentials(String userName,
			String password) {
		return mSession.getAccessTokenByCredentials();
	}

	@Override
	public OAuthToken getAccessTokenByRefreshToken(String refreshToken) {
		return mSession.getAccessTokenByRefreshToken();
	}

	private SimpleResponse sendRequest(String url, HttpMethod method,
			Map<String, String> parameters) throws IOException {
		return sendRequest(url, method, parameters, null);
	}

	private SimpleResponse sendRequest(String url, HttpMethod method,
			Map<String, String> parameters, Map<String, String> headers)
			throws IOException {
		return sendRequest(url, method, parameters, headers, null, null);
	}

	private SimpleResponse sendRequest(String url, HttpMethod method,
			Map<String, String> parameters, Map<String, String> headers,
			String key, File file) throws IOException {
		RequestBuilder builder = RequestBuilder.create();
		builder.setUrl(url).setMethod(method).addHeaders(headers)
				.addParameters(parameters);
		if (HttpMethod.POST == method || HttpMethod.PUT == method) {
			builder.addParameter(key, file);
		}
		if (HttpMethod.POST == method) {
			builder.addQueryParameter(DoubanConfig.OAuth.KEY_APPKEY,
					mSession.getApiKey());
		}
		if (mSession.isSessionValid()) {
			String accessToken = mSession.getToken();
			builder.setOAuth2(accessToken);
		}
		SimpleRequest simpleRequest = builder.build();
		return sendRequest(simpleRequest);
	}

	@SuppressWarnings("unused")
	private Authorization getAuthorizationFromSession() {
		if (mSession.isSessionValid()) {
			final Authorization authorization = new Authorization(
					Authorization.OAUTH2);
			authorization.setSignatureStyle(SignatureStyle.HEADER_BEARER);
			authorization.setApiKey(mSession.getApiKey());
			authorization.setApiSecret(mSession.getApiSecret());
			authorization.setToken(mSession.getToken());
			authorization.setSecret(mSession.getSecret());
			return authorization;
		} else {
			return null;
		}
	}

	private SimpleResponse sendRequest(final SimpleRequest simpleRequest)
			throws IOException {
		SimpleResponse simpleResponse = mClient.execute(simpleRequest);
		return simpleResponse;
	}

	private <T> DoubanResponse<T> get(String url) throws IOException {
		SimpleResponse response = sendRequest(url, HttpMethod.GET, null);
		return null;
	}

	private <T> DoubanResponse<T> get(String url, Map<String, String> parameters)
			throws IOException {
		SimpleResponse response = sendRequest(url, HttpMethod.GET, parameters);
		return null;
	}

	private <T> DoubanResponse<T> delete(String url) throws IOException {
		SimpleResponse response = sendRequest(url, HttpMethod.DELETE, null);
		return null;
	}

	private <T> DoubanResponse<T> delete(String url,
			Map<String, String> parameters) throws IOException {
		SimpleResponse response = sendRequest(url, HttpMethod.DELETE,
				parameters);
		return null;
	}

	private <T> DoubanResponse<T> post(String url,
			Map<String, String> parameters) throws IOException {
		SimpleResponse response = sendRequest(url, HttpMethod.POST, parameters);
		return null;
	}

	private <T> DoubanResponse<T> put(String url, Map<String, String> parameters)
			throws IOException {
		SimpleResponse response = sendRequest(url, HttpMethod.PUT, parameters);
		return null;
	}

}
