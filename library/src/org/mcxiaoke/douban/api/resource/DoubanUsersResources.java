/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;
import java.util.List;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanUser;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanUsersResources {

	// 用户信息

	DoubanResponse<DoubanUser> getUserInfo(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanUser> getAuthorizedUserInfo() throws DoubanException,
			IOException;

	// 用户操作

	DoubanResponse<DoubanUser> followUser(String userName)
			throws DoubanException, IOException;// need appkey

	DoubanResponse<DoubanUser> unfollowUser(String userName)
			throws DoubanException, IOException;// need appkey

	DoubanResponse<DoubanUser> blockUser(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanUser> unblockUser(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanRelation> getUsersRelation(String sourceName,
			String targetName) throws DoubanException, IOException;

	// appkey

	// 用户列表信息

	DoubanResponse<List<DoubanUser>> searchUser(String query)
			throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> searchUser(String query, int count,
			int start) throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName)
			throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName,
			int count, int start) throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName)
			throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName,
			int count, int start) throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(String userName)
			throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(String userName,
			int count, int start) throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName)
			throws DoubanException, IOException;

	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName,
			int count, int start) throws DoubanException, IOException;

}
