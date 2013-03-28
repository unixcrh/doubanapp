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
 *  用户相关的操作
 * @author mcxiaoke
 * @version 1.0 2013.03.25
 * @version 1.1 2013.03.26
 * @version 1.2 2013.03.28 add detail method comments
 * 
 */
public interface DoubanUsersResources {

	// 用户信息

	/**
	 * 获取用户信息
	 * 
	 * @param userName
	 *            用户名/ID
	 * @return 用户信息
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanUser> getUserInfo(String userName)
			throws DoubanException, IOException;

	/**
	 * 获取当前登录用户信息
	 * 
	 * @return 用户信息
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanUser> getAuthorizedUserInfo() throws DoubanException,
			IOException;

	// 用户操作

	/**
	 * 关注用户
	 * 
	 * @param userName
	 *            对象用户名/ID
	 * @return 对象用户信息
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanUser> followUser(String userName)
			throws DoubanException, IOException;// need appkey

	/**
	 * 取消关注
	 * 
	 * @param userName
	 *            对象用户名/ID
	 * @return 对象用户信息
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanUser> unfollowUser(String userName)
			throws DoubanException, IOException;// need appkey

	/**
	 * 加入黑名单
	 * 
	 * @param userName
	 *            对象用户名/ID
	 * @return 对象用户信息
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanUser> blockUser(String userName)
			throws DoubanException, IOException;

	/**
	 * 移出黑名单
	 * 
	 * @param userName
	 *            对象用户名/ID
	 * @return 对象用户信息
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanUser> unblockUser(String userName)
			throws DoubanException, IOException;

	/**
	 * 获取两用户的关系
	 * 
	 * @param sourceName
	 *            用户名
	 * @param targetName
	 *            用户名
	 * @return 关系信息
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanRelation> getUsersRelation(String sourceName,
			String targetName) throws DoubanException, IOException;

	// appkey

	// 用户列表信息

	/**
	 * 查询用户
	 * 
	 * @param query
	 *            查询字符串
	 * @return 用户信息结果列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> searchUser(String query)
			throws DoubanException, IOException;

	/**
	 * 查询用户
	 * 
	 * @param query
	 *            查询字符串
	 * @param count
	 *            数目
	 * @param start
	 *            分页
	 * @return 用户信息结果列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> searchUser(String query, int count,
			int start) throws DoubanException, IOException;

	/**
	 * 获取关注的用户列表
	 * 
	 * @param userName
	 *            用户名/ID
	 * @return 用户信息列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName)
			throws DoubanException, IOException;

	/**
	 * 获取关注的用户列表
	 * 
	 * @param userName
	 *            用户名/ID
	 * @param count
	 *            数目
	 * @param start
	 *            分页
	 * @return 用户信息列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName,
			int count, int start) throws DoubanException, IOException;

	/**
	 * 获取关注者列表
	 * 
	 * @param userName
	 *            用户名/ID
	 * @return 用户信息列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName)
			throws DoubanException, IOException;

	/**
	 * 获取关注者列表
	 * 
	 * @param userName
	 *            用户名/ID
	 * @param count
	 *            数目
	 * @param start
	 *            分页
	 * @return 用户信息列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName,
			int count, int start) throws DoubanException, IOException;

	/**
	 * 获取共同关注的用户列表
	 * 
	 * @param userName
	 *            用户名
	 * @return 用户信息列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(String userName)
			throws DoubanException, IOException;

	/**
	 * 获取共同关注的用户列表
	 * 
	 * @param userName
	 *            用户名
	 * @param count
	 *            数目
	 * @param start
	 *            分页
	 * @return 用户信息列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(String userName,
			int count, int start) throws DoubanException, IOException;

	/**
	 * 获取当前用户关注的人中也关注了该用户的列表
	 * 
	 * @param userName
	 *            用户名
	 * @return 用户信息列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName)
			throws DoubanException, IOException;

	/**
	 * 获取当前用户关注的人中也关注了该用户的列表
	 * 
	 * @param userName
	 *            用户名
	 * @param count
	 *            数目
	 * @param start
	 *            分页
	 * @return 用户信息类别
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName,
			int count, int start) throws DoubanException, IOException;

}
