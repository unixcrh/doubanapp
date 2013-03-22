/**
 * 
 */
package org.mcxiaoke.douban;

import org.mcxiaoke.commons.util.AssertUtils;
import org.scribe.model.OAuthToken;

import android.content.Context;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanClientImpl implements DoubanClient {
	private Context context;
	private DoubanSession session;

	public DoubanClientImpl(Context context, DoubanSession session) {
		AssertUtils.notNull(context,
				"context must not be null, suggested use ApplicationContext.");
		AssertUtils.notNull(session, "session must not be null.");
		this.context = context.getApplicationContext();
		this.session = session;
	}

	@Override
	public String getAuthorizeUrl() {
		return session.getAuthorizeUrl();
	}

	@Override
	public OAuthToken getAccessTokenByCode(String authorizeCode) {
		return session.getAccessTokenByCode();
	}

	@Override
	public OAuthToken getAccessTokenByCredentials(String userName,
			String password) {
		return session.getAccessTokenByCredentials();
	}

	@Override
	public OAuthToken getAccessTokenByRefreshToken(String refreshToken) {
		return session.getAccessTokenByRefreshToken();
	}

}
