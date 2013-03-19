package org.mcxiaoke.commons.http.auth;

import org.mcxiaoke.commons.http.auth.OAuthConstants.OAuthParameterStyle;
import org.mcxiaoke.commons.util.StringUtils;

public class OAuthConfig implements java.io.Serializable {
	private static final long serialVersionUID = -413250347293002921L;

	public static final int BASIC = 0;
	public static final int OAUTH1 = 1;
	public static final int OAUTH2 = 2;

	private final int authType;
	private String apiKey;
	private String apiSecret;
	private OAuthParameterStyle parameterStyle = OAuthParameterStyle.AUTHORIZATION_HEADER;
	private String token;
	private String secret;;

	public OAuthConfig(int type) {
		this.authType = type;
	}

	public OAuthConfig(String token) {
		this.authType = OAUTH2;
		this.token = token;
	}

	public OAuthConfig(String userName, String password) {
		this.authType = BASIC;
		this.apiKey = userName;
		this.apiSecret = password;
	}

	public OAuthConfig(String apiKey, String apiSecret, String token,
			String secret) {
		this.authType = OAUTH1;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.token = token;
		this.secret = secret;
	}

	public int getAuthType() {
		return authType;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	public String getAccessToken() {
		return token;
	}

	public String getAccessTokenSecret() {
		return secret;
	}

	public OAuthParameterStyle getOAuthParameterStyle() {
		return parameterStyle;
	}

	public void setOAuthParameterStyle(OAuthParameterStyle style) {
		this.parameterStyle = style;
	}

	public boolean isAuthorized() {
		boolean authorized = false;
		switch (authType) {
		case BASIC:
			authorized = (StringUtils.isNotEmpty(getAccessToken()) && StringUtils
					.isNotEmpty(getAccessTokenSecret()));
			break;
		case OAUTH1:
			authorized = (StringUtils.isNotEmpty(getApiKey())
					&& StringUtils.isNotEmpty(getApiSecret())
					&& StringUtils.isNotEmpty(getAccessToken()) && StringUtils
					.isNotEmpty(getAccessTokenSecret()));
			break;
		case OAUTH2:
			authorized = (StringUtils.isNotEmpty(getAccessToken()));
			break;
		default:
			break;
		}
		return authorized;
	}

}