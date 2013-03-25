/**
 * 
 */
package org.mcxiaoke.douban;

import android.content.Context;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanApiClientFactory {

	public static DoubanApiClient getApiClient(Context context,
			DoubanSession session) {
		return new DoubanApiClientImpl(context, session);
	}

}
