/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanComments;
import org.mcxiaoke.douban.api.model.DoubanNote;
import org.mcxiaoke.douban.api.model.DoubanNotes;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanNotesResources {

	// 日记列表

	DoubanNotes getNotesUserCreated(String userName);

	DoubanNotes getNotesUserCreated(String userName, String format);

	DoubanNotes getNotesUserCreated(long userId);

	DoubanNotes getNotesUserCreated(long userId, String format);

	DoubanNotes getNotesUserLiked(String userName);

	DoubanNotes getNotesUserLiked(String userName, String format);

	DoubanNotes getNotesUserLiked(long userId);

	DoubanNotes getNotesUserLiked(long userId, String format);

	DoubanNotes getNotesGuesses(String userName);

	DoubanNotes getNotesGuesses(String userName, String format);

	DoubanNotes getNotesGuesses(long userId);

	DoubanNotes getNotesGuesses(long userId, String format);

	// 日记

	DoubanNote getNote(long noteId);

	DoubanNote getNote(long noteId, String format);

	DoubanNote delete(long noteId);

	DoubanNote likeNote(long noteId);

	DoubanNote unlikeNote(long noteId);

	// 写日记

	DoubanNote writeNote(String title, String content);

	DoubanNote writeNote(String title, String content, boolean canReply);

	DoubanNote writeNote(String title, String content, boolean canReply,
			String privacy);

	DoubanNote updateNote(long noteId, String title, String content);

	DoubanNote updateNote(long noteId, String title, String content,
			boolean canReply);

	DoubanNote updateNote(long noteId, String title, String content,
			boolean canReply, String privacy);

	// 日记回复
	DoubanComments getNoteComments(long noteId);

	DoubanComment addNoteComment(long noteId, String text);

	DoubanComment getNoteComment(long noteId, long commentId);

	DoubanComment deleteNoteComment(long noteId, long commentId);

}
