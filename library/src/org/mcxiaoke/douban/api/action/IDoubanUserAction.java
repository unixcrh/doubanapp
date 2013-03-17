/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import org.mcxiaoke.douban.api.model.DoubanUser;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanUserAction {

	// GET https://api.douban.com/v2/user/:name
	DoubanUser getUserInfo(String userId);

	// GET https://api.douban.com/v2/user/~me
	DoubanUser getUserInfo();

	// GET https://api.douban.com/v2/user
	DoubanUsers searchUser(String query, int start, int count);

}
