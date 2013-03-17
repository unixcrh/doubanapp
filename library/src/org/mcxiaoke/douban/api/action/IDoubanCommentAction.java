/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanComments;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanCommentAction {

	// GET https://api.douban.com/v2/target/:id/comments
	DoubanComments getComments(String target, long id);

	// POST https://api.douban.com/v2/target/:id/comments
	DoubanComment writeComment(String target, long id, String content);

	// GET https://api.douban.com/v2/target/:id/comment/:id
	DoubanComment getComment(String target, long id, long commentId);

}
