/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import java.util.List;

import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanShuo;
import org.mcxiaoke.douban.api.model.DoubanUser;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanShuoAction {

	// POST shuo/v2/statuses/
	DoubanShuo updateStatus(String source, String text, byte[] image);

	// POST shuo/v2/statuses/
	DoubanShuo updateStatus(String source, String text, byte[] image,
			String recTitle, String recUrl, String recDesc, String recImage);

	// GET shuo/v2/statuses/home_timeline
	List<DoubanShuo> getHomeTimeline(int count, int start, long sinceId,
			long utilId);

	// GET shuo/v2/statuses/user_timeline/:user_id
	List<DoubanShuo> getUserTimeline(long sinceId, long utilId);

	// GET shuo/v2/statuses/user_timeline/:user_id
	List<DoubanShuo> getUserTimeline(long userId, int count, int start,
			long sinceId, long utilId);

	// GET shuo/v2/statuses/user_timeline/:user_id
	List<DoubanShuo> getUserTimeline(String userId, int count, int start,
			long sinceId, long utilId);

	// GET shuo/v2/statuses/:id
	DoubanShuo getStatus(long statusId, boolean trim);

	// DELETE shuo/v2/statuses/:id
	DoubanShuo deleteStatus(long statusId);

	// GET shuo/v2/statuses/:id/comments
	List<DoubanComment> getStatusComments(long statusId, int start, int count);

	// POST shuo/v2/statuses/:id/comments text=aaa
	DoubanComment postStatusComment(String text);

	// GET shuo/v2/statuses/comment/:id
	DoubanComment getStatusComment(long commentId);

	// DELETE shuo/v2/statuses/comment/:id
	DoubanComment deleteStatusComment(long commentId);

	// GET shuo/v2/statuses/:id/reshare
	List<DoubanUser> getStatusReshares(long statusId);

	// POST shuo/v2/statuses/:id/reshare
	DoubanShuo reshareStatus(long statusId);

	// GET shuo/v2/statuses/:id/like
	List<DoubanUser> getStatusLikes(long statusId);

	// POST shuo/v2/statuses/:id/like
	DoubanShuo likeStatus(long statusId);

	// DELETE shuo/v2/statuses/:id/like
	DoubanShuo unlikeStatus(long statusId);

	// GET shuo/v2/users/:id/following
	List<DoubanUser> getUsersFollowing(String userId);

	// GET shuo/v2/users/:id/followers
	List<DoubanUser> getUsersFollowers(String userId);

	// GET shuo/v2/users/:id/follow_in_common
	List<DoubanUser> getUsersFollowInCommon(String userId);

	// GET shuo/v2/users/:id/following_followers_of
	List<DoubanUser> getUsersFollowingAlso(String userId);

	// GET shuo/v2/users/search
	List<DoubanUser> getUsersSearch(String query);

	// POST shuo/v2/users/:id/block
	DoubanUser blockUser(String userId);

	// POST shuo/v2/friendships/create
	DoubanUser followUser(String userId, String source);

	// POST shuo/v2/friendships/destroy
	DoubanUser unfollowUser(String userId, String source);

	// GET shuo/v2/friendships/show
	String getFrienhships(String sourceId, String targetId, String source);

}
