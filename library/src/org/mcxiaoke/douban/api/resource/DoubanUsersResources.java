/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.util.List;

import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanUser;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanUsersResources {

	// 用户信息

	DoubanResponse<DoubanUser> getUserInfo(long userId);

	DoubanResponse<DoubanUser> getUserInfo(String userName);

	DoubanResponse<DoubanUser> getAuthorizedUserInfo();

	// 用户操作
	DoubanResponse<DoubanUser> followUser(long userId);// need appkey

	DoubanResponse<DoubanUser> followUser(String userName);// need appkey

	DoubanResponse<DoubanUser> unfollowUser(long userId);// need appkey

	DoubanResponse<DoubanUser> unfollowUser(String userName);// need appkey

	DoubanResponse<DoubanUser> blockUser(long userId);

	DoubanResponse<DoubanUser> blockUser(String userName);

	DoubanResponse<DoubanUser> unblockUser(long userId);

	DoubanResponse<DoubanUser> unblockUser(String userName);

	DoubanResponse<DoubanRelation> getUsersRelation(long sourceId, long targetId); // need

	DoubanResponse<DoubanRelation> getUsersRelation(String sourceName,
			String targetName);

	// appkey

	// 用户列表信息

	DoubanResponse<List<DoubanUser>> searchUser(String query);

	DoubanResponse<List<DoubanUser>> searchUser(String query, int count,
			int start);

	DoubanResponse<List<DoubanUser>> getFollowingUsers(long userId);

	DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName);

	DoubanResponse<List<DoubanUser>> getFollowingUsers(long userId, int count,
			int start);

	DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName,
			int count, int start);

	DoubanResponse<List<DoubanUser>> getFollowersUsers(long userId);

	DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName);

	DoubanResponse<List<DoubanUser>> getFollowersUsers(long userId, int count,
			int start);

	DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName,
			int count, int start);

	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(long userId);

	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(String userName);

	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(long userId,
			int count, int start);

	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(String userName,
			int count, int start);

	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(long userId);

	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName);

	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(long userId,
			int count, int start);

	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName,
			int count, int start);

}
