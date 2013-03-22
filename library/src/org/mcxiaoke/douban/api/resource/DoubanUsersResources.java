/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.util.List;

import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanUser;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanUsersResources {

	// 用户信息

	DoubanUser getUserInfo(long userId);

	DoubanUser getUserInfo(String userName);

	DoubanUser getAuthorizedUserInfo();

	// 用户操作
	boolean followUser(long userId);// need appkey

	boolean followUser(String userName);// need appkey

	boolean unfollowUser(long userId);// need appkey

	boolean unfollowUser(String userName);// need appkey

	boolean blockUser(long userId);

	boolean blockUser(String userName);

	boolean unblockUser(long userId);

	boolean unblockUser(String userName);

	DoubanRelation getUsersRelation(long sourceId, long targetId); // need
																	// appkey

	// 用户列表信息

	DoubanUsers searchUser(String query);

	DoubanUsers searchUser(String query, int count, int start);

	List<DoubanUser> getFollowingUsers(long userId);

	List<DoubanUser> getFollowingUsers(String userName);

	List<DoubanUser> getFollowingUsers(long userId, int tag);

	List<DoubanUser> getFollowingUsers(String userName, int tag);

	List<DoubanUser> getFollowersUsers(long userId);

	List<DoubanUser> getFollowersUsers(String userName);

	List<DoubanUser> getFollowInCommonUsers(long userId);

	List<DoubanUser> getFollowInCommonUsers(String userName);

	List<DoubanUser> getFollowingOfUsers(long userId);

	List<DoubanUser> getFollowingOfUsers(String userName);

}
