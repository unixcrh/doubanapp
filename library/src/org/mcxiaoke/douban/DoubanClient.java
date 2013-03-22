package org.mcxiaoke.douban;

import org.scribe.model.OAuthToken;

public interface DoubanClient {

	public abstract String getAuthorizeUrl();

	public abstract OAuthToken getAccessTokenByCode(String authorizeCode);

	public abstract OAuthToken getAccessTokenByCredentials(String userName, String password);

	public abstract OAuthToken getAccessTokenByRefreshToken(String refreshToken);

}