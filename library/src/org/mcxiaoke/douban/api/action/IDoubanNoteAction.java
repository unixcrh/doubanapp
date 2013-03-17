/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanComments;
import org.mcxiaoke.douban.api.model.DoubanNote;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanNoteAction {

	// POST https://api.douban.com/v2/notes
	DoubanNote writeNote(String title, String content, String privacy,
			boolean canReply);

	// PUT https://api.douban.com/v2/note/:id
	DoubanNote updateNote(String title, String content, String privacy,
			boolean canReply);

	// DELETE https://api.douban.com/v2/note/:id
	DoubanNote deleteNote(long noteId);

	// POST https://api.douban.com/v2/note/:id/like
	DoubanNote likeNote(long noteId);

	// DELETE https://api.douban.com/v2/note/:id/like
	DoubanNote unlikeNote(long noteId);

	// GET /v2/note/:id/comments
	DoubanComments getNoteComments(long noteId);

	// POST /v2/note/:id/comments
	DoubanComment writeNoteComment(long noteId, String content);

	// GET /v2/note/:id/comment/:id
	DoubanComment getNoteComment(long noteId, long commentId);

	// DELETE /v2/note/:id/comment/:id
	DoubanComment deleteNoteComment(long noteId, long commentId);

}

// 1006 target_not_found 找不到某条日记 400
// 1000 need_permission 没权限访问用户不可见的日记，或者没登录的情况下去访问需要登录的数据 403
// 1002 missing_args 请求的时候缺少必选的参数 400
// 1014 wrong_method 错误的http 请求方式，比如一些接口需要http PUT 却用http POST请求 400
// 1001 uri_not_found 未登录 或者访问的api 没有经过授权申请通过 404
