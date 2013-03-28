/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanShuo;
import org.mcxiaoke.douban.api.model.DoubanShuoStatus;
import org.mcxiaoke.douban.api.model.DoubanShuoUpdate;
import org.mcxiaoke.douban.api.model.DoubanUser;

/**
 * 广播相关的操作
 * 
 * @author mcxiaoke
 * @version 1.0 2013.03.24
 * @version 1.1 2013.03.26 add detail method comments
 * 
 */
public interface DoubanShuoResources {

	/**
	 * 发布一条广播
	 * 
	 * @param status
	 *            广播内容
	 * @return 发布成功的广播消息体
	 * @throws DoubanException
	 *             如果出现请求异常
	 * @throws IOException
	 *             如果出现网络错误
	 */
	DoubanResponse<DoubanShuoStatus> updateStatus(DoubanShuoUpdate status)
			throws DoubanException, IOException;

	/**
	 * 发布一条广播
	 * 
	 * @param text
	 *            广播文本
	 * @return 发布成功的广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> updateStatus(String text)
			throws DoubanException, IOException;

	/**
	 * 发布一条广播，包含图片
	 * 
	 * @param text
	 *            广播文本
	 * @param image
	 *            广播图片
	 * @return 发布成功的广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> updateStatus(String text, File image)
			throws DoubanException, IOException;

	/**
	 * 发布一条广播，推荐网址
	 * 
	 * @param text
	 *            广播文本
	 * @param title
	 *            推荐网址标题
	 * @param url
	 *            推荐网址URL
	 * @param desc
	 *            推荐网址描述
	 * @return 发布成功的广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> updateStatus(String text, String title,
			String url, String desc) throws DoubanException, IOException;

	/**
	 * 发布一条广播，推荐网址，包含图片
	 * 
	 * @param text
	 *            广播文本
	 * @param title
	 *            推荐网址标题
	 * @param url
	 *            推荐网址URL
	 * @param desc
	 *            推荐网址描述
	 * @param imageUrl
	 *            推荐网址图片URL
	 * @return 发布成功的广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> updateStatus(String text, String title,
			String url, String desc, String imageUrl) throws DoubanException,
			IOException;

	// 操作广播
	/**
	 * 获取一条广播，广播内容
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> showStatusConent(long statusId)
			throws DoubanException, IOException;

	/**
	 * 获取一条广播，包含转发和评论等信息
	 * 
	 * @param statusId
	 *            广播ID
	 * @param simple
	 *            精简消息体，不显示转发
	 * @return 广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuo> showStatus(long statusId, boolean pack)
			throws DoubanException, IOException;

	/**
	 * 删除一条广播
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> deleteStatus(long statusId)
			throws DoubanException, IOException;

	/**
	 * 获取转发此条广播的用户列表
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 转发此条消息的用户列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getStatusReshareUsers(long statusId)
			throws DoubanException, IOException;

	/**
	 * 转发一条广播
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> reshareStatus(long statusId)
			throws DoubanException, IOException;

	/**
	 * 取消转发一条广播
	 * 
	 * @param statusId
	 *            转发后的广播ID
	 * @return 广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> unreshareStatus(long statusId)
			throws DoubanException, IOException;

	/**
	 * 获取赞一条广播的用户列表
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 赞一条广播的用户列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanUser>> getStatusLikeUsers(long statusId)
			throws DoubanException, IOException;

	/**
	 * 赞一条广播
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> likeStatus(long statusId)
			throws DoubanException, IOException;

	/**
	 * 取消赞一条广播
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 广播消息体
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanShuoStatus> unlikeStatus(long statusId)
			throws DoubanException, IOException;

	// 广播评论
	/**
	 * 获取一条广播的评论列表
	 * 
	 * @param statusId
	 *            广播ID
	 * @return 评论列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanComment>> getStatusComments(long statusId)
			throws DoubanException, IOException;

	/**
	 * 获取一条广播的评论列表
	 * 
	 * @param statusId
	 *            广播ID
	 * @param count
	 *            获取评论数目
	 * @return 评论列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanComment>> getStatusComments(long statusId,
			int count) throws DoubanException, IOException;

	/**
	 * 获取一条广播的评论列表
	 * 
	 * @param statusId
	 *            广播ID
	 * @param count
	 *            获取评论数目
	 * @param start
	 *            获取评论分页
	 * @return 评论列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanComment>> getStatusComments(long statusId,
			int count, int start) throws DoubanException, IOException;

	/**
	 * 回复一条广播
	 * 
	 * @param statusId
	 *            广播ID
	 * @param text
	 *            回复文本
	 * @return 发布成功的回复
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanComment> addStatusComment(long statusId, String text)
			throws DoubanException, IOException;

	/**
	 * 删除一条广播的回复
	 * 
	 * @param commentId
	 *            回复ID
	 * @return 删除成功的回复
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanComment> deleteStatusComment(long commentId)
			throws DoubanException, IOException;

	/**
	 * 获取一条回复
	 * 
	 * @param commentId
	 *            回复ID
	 * @return 回复内容
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<DoubanComment> getStatusComment(long commentId)
			throws DoubanException, IOException;

	// 时间线
	// home timeline
	/**
	 * 获取主页时间线
	 * 
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline()
			throws DoubanException, IOException;

	/**
	 * 获取主页时间线
	 * 
	 * @param sinceId
	 *            起始广播ID
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId)
			throws DoubanException, IOException;

	/**
	 * 获取主页时间线
	 * 
	 * @param sinceId
	 *            起始广播ID
	 * @param maxId
	 *            终止广播ID
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId,
			long maxId) throws DoubanException, IOException;

	/**
	 * 获取主页时间线
	 * 
	 * @param sinceId
	 *            起始广播ID
	 * @param maxId
	 *            终止广播ID
	 * @param count
	 *            广播数目
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId,
			long maxId, int count) throws DoubanException, IOException;

	/**
	 * 获取主页时间线
	 * 
	 * @param sinceId
	 *            起始广播ID
	 * @param maxId
	 *            终止广播ID
	 * @param count
	 *            广播数目
	 * @param start
	 *            广播分页
	 * @return
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId,
			long maxId, int count, int start) throws DoubanException,
			IOException;

	// user timeline

	/**
	 * 用户时间线
	 * 
	 * @param userName
	 *            用户名
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(String userName)
			throws DoubanException, IOException;

	/**
	 * 用户时间线
	 * 
	 * @param userName
	 *            用户名
	 * @param sinceId
	 *            广播起始ID
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(String userName,
			long sinceId) throws DoubanException, IOException;

	/**
	 * 用户时间线
	 * 
	 * @param userName
	 *            用户名
	 * @param sinceId
	 *            广播起始ID
	 * @param maxId
	 *            广播终止ID
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(String userName,
			long sinceId, long maxId) throws DoubanException, IOException;

	/**
	 * 用户时间线
	 * 
	 * @param userName
	 *            用户名
	 * @param sinceId
	 *            广播起始ID
	 * @param maxId
	 *            广播终止ID
	 * @param count
	 *            广播数目
	 * @return 广播列表
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(String userName,
			long sinceId, long maxId, int count) throws DoubanException,
			IOException;

	/**
	 * 用户时间线
	 * 
	 * @param userName
	 *            用户名
	 * @param sinceId
	 *            广播起始ID
	 * @param maxId
	 *            广播终止ID
	 * @param count
	 *            广播数目
	 * @param start
	 *            广播分页
	 * @return
	 * @throws DoubanException
	 * @throws IOException
	 */
	DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(String userName,
			long sinceId, long maxId, int count, int start)
			throws DoubanException, IOException;

}
