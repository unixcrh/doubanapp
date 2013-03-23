/**
 * 
 */
package org.mcxiaoke.douban;

import android.content.Context;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanClientFactory {

	public static DoubanClient createDoubanClient(Context context,
			DoubanSession session) {
		return new DoubanClientImpl(context, session);
	}

}
