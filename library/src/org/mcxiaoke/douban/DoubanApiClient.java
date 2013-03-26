package org.mcxiaoke.douban;

import org.mcxiaoke.douban.api.resource.DoubanShuoResources;
import org.mcxiaoke.douban.api.resource.DoubanUsersResources;
import org.scribe.model.OAuthToken;

public interface DoubanApiClient extends DoubanUsersResources,DoubanShuoResources{

	public String getAuthorizeUrl();

	public OAuthToken login(String authorizeCode);

	public OAuthToken login(String userName, String password);

	public OAuthToken relogin(String refreshToken);

}