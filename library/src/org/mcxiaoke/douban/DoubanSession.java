/**
 * 
 */
package org.mcxiaoke.douban;

import org.mcxiaoke.commons.util.AssertUtils;
import org.mcxiaoke.commons.util.NetworkUtils;
import org.mcxiaoke.commons.util.StringUtils;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.DoubanApi20;
import org.scribe.model.GrantType;
import org.scribe.model.OAuthToken;
import org.scribe.model.ResponseType;
import org.scribe.model.SignatureType;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import android.content.Context;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanSession {
	private static final OAuthToken NULL_TOKEN = null;
	private Context context;
	private OAuthToken oauthToken = OAuthToken.EMPTY();

	private final String apiKey;
	private final String apiSecret;
	private String callbackUrl;
	private String scope;
	private final ServiceBuilder serviceBuilder;

	private String authorizeCode;
	private String userName;
	private String password;

	public static void saveSession() {

	}

	public static DoubanSession restoreSession() {
		return null;
	}

	public DoubanSession(Context context, String apiKey, String apiSecret) {
		this(context, apiKey, apiSecret, null);
	}

	public DoubanSession(Context context, String apiKey, String apiSecret,
			String callbackUrl) {
		this(context, apiKey, apiSecret, callbackUrl, null);
	}

	public DoubanSession(Context context, String apiKey, String apiSecret,
			String callbackUrl, String scope) {
		AssertUtils.notNull(context, "context cannot be null.");
		AssertUtils.notEmpty(apiKey, "apiKey cannot be null or empty.");
		AssertUtils.notEmpty(apiSecret, "apiSecret cannot be null or empty.");
		this.context = context;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.callbackUrl = callbackUrl;
		this.scope = scope;
		this.serviceBuilder = new ServiceBuilder().provider(DoubanApi20.class)
				.responseType(ResponseType.CODE)
				.signatureType(SignatureType.HEADER_BEARER).apiKey(apiKey)
				.apiSecret(apiSecret);
	}

	public String getAuthorizeUrl() {
		AssertUtils.notEmpty(callbackUrl,
				"callbackUrl cannot be null or empty.");
		return serviceBuilder.callback(callbackUrl).scope(scope).build()
				.getAuthorizationUrl(NULL_TOKEN);
	}

	public OAuthToken getAccessTokenByCode() {
		return getAccessTokenByCode(authorizeCode);
	}

	public OAuthToken getAccessTokenByCode(String code) {
		AssertUtils.notEmpty(code, "authorizeCode cannot be null or empty.");
		OAuthService service = serviceBuilder.grantType(
				GrantType.AUTHORIZATION_CODE).build();
		service.setProxy(NetworkUtils.getProxyForChina(context));
		OAuthToken token = service.getAccessToken(NULL_TOKEN,
				new Verifier(code));
		this.oauthToken.update(token);
		return token;
	}

	public OAuthToken getAccessTokenByCredentials() {
		return getAccessTokenByCredentials(userName, password);
	}

	public OAuthToken getAccessTokenByCredentials(String userName,
			String password) {
		AssertUtils.notEmpty(userName, "userName cannot be null or empty.");
		AssertUtils.notEmpty(password, "password cannot be null or empty.");
		String verifier = userName + ":" + password;
		OAuthService service = serviceBuilder.grantType(
				GrantType.RESOURCE_OWNER_PASSWORD_CREDENTIALS).build();
		service.setProxy(NetworkUtils.getProxyForChina(context));
		OAuthToken token = service.getAccessToken(NULL_TOKEN, new Verifier(
				verifier));
		this.oauthToken.update(token);
		return token;
	}

	public OAuthToken getAccessTokenByRefreshToken() {
		return getAccessTokenByRefreshToken(oauthToken.getSecret());
	}

	public OAuthToken getAccessTokenByRefreshToken(String refreshToken) {
		AssertUtils.notEmpty(refreshToken,
				"refreshToken cannot be null or empty.");
		OAuthService service = serviceBuilder
				.grantType(GrantType.REFRESH_TOKEN).build();
		service.setProxy(NetworkUtils.getProxyForChina(context));
		OAuthToken token = service.getAccessToken(NULL_TOKEN, new Verifier(
				refreshToken));
		this.oauthToken.update(token);
		return token;
	}

	public boolean isKeyAndSecretValid() {
		return StringUtils.isNotEmpty(apiKey)
				&& StringUtils.isNotEmpty(apiSecret);
	}

	public boolean isSessionValid() {
		return !isSessionInvalid();
	}

	public boolean isSessionInvalid() {
		return isSessionEmpty() || isSessionExpired();
	}

	public boolean isSessionEmpty() {
		return oauthToken == null || oauthToken.isEmpty();
	}

	public boolean isSessionExpired() {
		return !isSessionEmpty()
				&& oauthToken.getExpiresAt() <= System.currentTimeMillis();
	}

	public String getToken() {
		return oauthToken == null ? null : oauthToken.getToken();
	}

	public String getSecret() {
		return oauthToken == null ? null : oauthToken.getSecret();
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public OAuthToken getOAuthToken() {
		return oauthToken;
	}

	public void setOAuthToken(OAuthToken token) {
		this.oauthToken = token;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorizeCode() {
		return authorizeCode;
	}

	public void setAuthorizeCode(String authorizeCode) {
		this.authorizeCode = authorizeCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getApiSecret() {
		return apiSecret;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanSession [context=");
		builder.append(context);
		builder.append(", token=");
		builder.append(oauthToken);
		builder.append(", apiKey=");
		builder.append(apiKey);
		builder.append(", apiSecret=");
		builder.append(apiSecret);
		builder.append(", callbackUrl=");
		builder.append(callbackUrl);
		builder.append(", scope=");
		builder.append(scope);
		builder.append(", serviceBuilder=");
		builder.append(serviceBuilder);
		builder.append(", authorizeCode=");
		builder.append(authorizeCode);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
}
