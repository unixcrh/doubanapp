/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanShuo;
import org.mcxiaoke.douban.api.model.DoubanShuoUpdate;
import org.mcxiaoke.douban.api.model.DoubanUser;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanShuoResources {

	// 发布广播
	DoubanShuo updateStatus(DoubanShuoUpdate status);

	DoubanShuo updateStatus(String text);

	DoubanShuo updateStatus(String text, byte[] image);

	DoubanShuo updateStatus(String text, File image);

	DoubanShuo updateStatus(String text, InputStream inputStream);

	DoubanShuo updateStatus(String title, String url, String desc);

	DoubanShuo updateStatus(String title, String url, String desc,
			String imageUrl);

	// 操作广播
	DoubanShuo showStatus(long statusId);

	DoubanShuo showStatus(long statusId, boolean simple);

	DoubanShuo deleteStatus(long statusId);

	DoubanShuo deleteStatus(long statusId, boolean simple);

	List<DoubanUser> getStatusReshareUsers(long statusId);

	DoubanShuo reshareStatus(long statusId);

	DoubanShuo unreshareStatus(long statusId);

	List<DoubanUser> getStatusLikeUsers(long statusId);

	DoubanShuo likeStatus(long statusId);

	DoubanShuo unlikeStatus(long statusId);

	// 广播评论
	List<DoubanComment> getStatusComments(long statusId);

	List<DoubanComment> getStatusComments(long statusId, int count);

	List<DoubanComment> getStatusComments(long statusId, int count, int start);

	DoubanComment addStatusComment(long statusId, String text);

	DoubanComment deleteStatusComment(long commentId);

	DoubanComment getStatusComment(long commentId);

	// 时间线
	// home timeline
	List<DoubanShuo> getHomeTimeline(long sinceId);

	List<DoubanShuo> getHomeTimeline(long sinceId, long maxId);

	List<DoubanShuo> getHomeTimeline(long sinceId, long maxId, int count);

	List<DoubanShuo> getHomeTimeline(long sinceId, long maxId, int count,
			int start);

	// user timeline
	List<DoubanShuo> getUserTimeline(long userId, long sinceId);

	List<DoubanShuo> getUserTimeline(long userId, long sinceId, long maxId);

	List<DoubanShuo> getUserTimeline(long userId, long sinceId, long maxId,
			int count);

	List<DoubanShuo> getUserTimeline(long userId, long sinceId, long maxId,
			int count, int start);

	List<DoubanShuo> getUserTimeline(String userName, long sinceId);

	List<DoubanShuo> getUserTimeline(String userName, long sinceId, long maxId);

	List<DoubanShuo> getUserTimeline(String userName, long sinceId, long maxId,
			int count);

	List<DoubanShuo> getUserTimeline(String userName, long sinceId, long maxId,
			int count, int start);

}
