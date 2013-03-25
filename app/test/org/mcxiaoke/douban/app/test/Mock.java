/**
 * 
 */
package org.mcxiaoke.douban.app.test;

import org.mcxiaoke.douban.DoubanConfig;
import org.mcxiaoke.douban.DoubanSession;
import org.scribe.model.OAuthToken;

import android.content.Context;

/**
 * @author mcxiaoke
 * 
 */
public final class Mock {
	public static final String API_KEY = "06fd45e1d2ad245a14f7d1a578076d0e";
	public static final String API_SECRET = "b29538157b254bd1";
	public static final String CALLBACK_URL = "http://www.baidu.com";
	public static final String SCOPE = DoubanConfig.OAuth.getDefaultScope();

	public static final String TOKEN = "9ff74625020469f2dfe5d26f060d3dd6";
	public static final String SECRET = "202d2dc0880fc4bd60878941982f4e37";
	public static final long UID = 1376127;
	public static final long EXPIRES_IN = 604800;

	public static final String TEST_USER_NAME_ME = "mcxiaoke";
	public static final String TEST_USER_NAME = "duxiaoming";
	public static final String TEST_USER_NAME2 = "dstyle";
	public static final String TEST_USER_NAME_NOT_EXISTS = "mcxiaoke123";
	public static final long TEST_USER_ID = 48737437;
	public static final long TEST_USER_ID_ME = 1376127;
	public static final long TEST_USER_ID_NOT_EXISTS = 487374373;

	public static DoubanSession mockDoubanSession(Context context) {
		DoubanSession session = new DoubanSession(context, API_KEY, API_SECRET);
		session.setCallbackUrl(CALLBACK_URL);
		session.setScope(SCOPE);
		return session;
	}

	public static DoubanSession mockDoubanSessionWithToken(Context context) {
		DoubanSession session = new DoubanSession(context, API_KEY, API_SECRET);
		session.setCallbackUrl(CALLBACK_URL);
		session.setScope(SCOPE);
		session.setOAuthToken(new OAuthToken(TOKEN, SECRET, EXPIRES_IN
				+ System.currentTimeMillis()));
		return session;
	}

}
