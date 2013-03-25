/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.DoubanResponse;
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

	DoubanResponse<DoubanNotes> getNotesUserCreated(String userName);

	DoubanResponse<DoubanNotes> getNotesUserCreated(String userName,
			String format);

	DoubanResponse<DoubanNotes> getNotesUserCreated(long userId);

	DoubanResponse<DoubanNotes> getNotesUserCreated(long userId, String format);

	DoubanResponse<DoubanNotes> getNotesUserLiked(String userName);

	DoubanResponse<DoubanNotes> getNotesUserLiked(String userName, String format);

	DoubanResponse<DoubanNotes> getNotesUserLiked(long userId);

	DoubanResponse<DoubanNotes> getNotesUserLiked(long userId, String format);

	DoubanResponse<DoubanNotes> getNotesGuesses(String userName);

	DoubanResponse<DoubanNotes> getNotesGuesses(String userName, String format);

	DoubanResponse<DoubanNotes> getNotesGuesses(long userId);

	DoubanResponse<DoubanNotes> getNotesGuesses(long userId, String format);

	// 日记

	DoubanResponse<DoubanNote> getNote(long noteId);

	DoubanResponse<DoubanNote> getNote(long noteId, String format);

	DoubanResponse<DoubanNote> delete(long noteId);

	DoubanResponse<DoubanNote> likeNote(long noteId);

	DoubanResponse<DoubanNote> unlikeNote(long noteId);

	// 写日记

	DoubanResponse<DoubanNote> writeNote(String title, String content);

	DoubanResponse<DoubanNote> writeNote(String title, String content,
			boolean canReply);

	DoubanResponse<DoubanNote> writeNote(String title, String content,
			boolean canReply, String privacy);

	DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content);

	DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content, boolean canReply);

	DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content, boolean canReply, String privacy);

	// 日记回复
	DoubanResponse<DoubanComments> getNoteComments(long noteId);

	DoubanResponse<DoubanComment> addNoteComment(long noteId, String text);

	DoubanResponse<DoubanComment> getNoteComment(long noteId, long commentId);

	DoubanResponse<DoubanComment> deleteNoteComment(long noteId, long commentId);

}
