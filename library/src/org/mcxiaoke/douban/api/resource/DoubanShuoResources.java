/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.mcxiaoke.douban.DoubanResponse;
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
	DoubanResponse<DoubanShuo> updateStatus(DoubanShuoUpdate status);

	DoubanResponse<DoubanShuo> updateStatus(String text);

	DoubanResponse<DoubanShuo> updateStatus(String text, byte[] image);

	DoubanResponse<DoubanShuo> updateStatus(String text, File image);

	DoubanResponse<DoubanShuo> updateStatus(String text, InputStream inputStream);

	DoubanResponse<DoubanShuo> updateStatus(String title, String url,
			String desc);

	DoubanResponse<DoubanShuo> updateStatus(String title, String url,
			String desc, String imageUrl);

	// 操作广播
	DoubanResponse<DoubanShuo> showStatus(long statusId);

	DoubanResponse<DoubanShuo> showStatus(long statusId, boolean simple);

	DoubanResponse<DoubanShuo> deleteStatus(long statusId);

	DoubanResponse<DoubanShuo> deleteStatus(long statusId, boolean simple);

	DoubanResponse<List<DoubanUser>> getStatusReshareUsers(long statusId);

	DoubanResponse<DoubanShuo> reshareStatus(long statusId);

	DoubanResponse<DoubanShuo> unreshareStatus(long statusId);

	DoubanResponse<List<DoubanUser>> getStatusLikeUsers(long statusId);

	DoubanShuo likeStatus(long statusId);

	DoubanShuo unlikeStatus(long statusId);

	// 广播评论
	DoubanResponse<List<DoubanComment>> getStatusComments(long statusId);

	DoubanResponse<List<DoubanComment>> getStatusComments(long statusId,
			int count);

	DoubanResponse<List<DoubanComment>> getStatusComments(long statusId,
			int count, int start);

	DoubanResponse<DoubanComment> addStatusComment(long statusId, String text);

	DoubanResponse<DoubanComment> deleteStatusComment(long commentId);

	DoubanResponse<DoubanComment> getStatusComment(long commentId);

	// 时间线
	// home timeline
	DoubanResponse<DoubanResponse<List<DoubanShuo>>> getHomeTimeline(
			long sinceId);

	DoubanResponse<List<DoubanShuo>> getHomeTimeline(long sinceId, long maxId);

	DoubanResponse<List<DoubanShuo>> getHomeTimeline(long sinceId, long maxId,
			int count);

	DoubanResponse<List<DoubanShuo>> getHomeTimeline(long sinceId, long maxId,
			int count, int start);

	// user timeline
	DoubanResponse<List<DoubanShuo>> getUserTimeline(long userId, long sinceId);

	DoubanResponse<List<DoubanShuo>> getUserTimeline(long userId, long sinceId,
			long maxId);

	DoubanResponse<List<DoubanShuo>> getUserTimeline(long userId, long sinceId,
			long maxId, int count);

	DoubanResponse<List<DoubanShuo>> getUserTimeline(long userId, long sinceId,
			long maxId, int count, int start);

	DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId);

	DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId, long maxId);

	DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId, long maxId, int count);

	DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId, long maxId, int count, int start);

}
