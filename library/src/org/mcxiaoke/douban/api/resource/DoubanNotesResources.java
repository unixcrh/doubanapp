/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;

import org.mcxiaoke.douban.DoubanException;
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

	DoubanResponse<DoubanNotes> getNotesUserCreated(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesUserCreated(String userName, int count,
			String format) throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesUserCreated(String userName, int count,
			int start, String format) throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesUserLiked(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesUserLiked(String userName, int count,
			String format) throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesUserLiked(String userName, int count,
			int start, String format) throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesGuesses(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesGuesses(String userName, int count,
			String format) throws DoubanException, IOException;

	DoubanResponse<DoubanNotes> getNotesGuesses(String userName, int count,
			int start, String format) throws DoubanException, IOException;

	// 日记

	DoubanResponse<DoubanNote> getNote(long noteId) throws DoubanException,
			IOException;

	DoubanResponse<DoubanNote> getNote(long noteId, String format)
			throws DoubanException, IOException;

	DoubanResponse<DoubanNote> delete(long noteId) throws DoubanException,
			IOException;

	DoubanResponse<DoubanNote> likeNote(long noteId) throws DoubanException,
			IOException;

	DoubanResponse<DoubanNote> unlikeNote(long noteId) throws DoubanException,
			IOException;

	// 写日记

	DoubanResponse<DoubanNote> writeNote(String title, String content)
			throws DoubanException, IOException;

	DoubanResponse<DoubanNote> writeNote(String title, String content,
			boolean canReply) throws DoubanException, IOException;

	DoubanResponse<DoubanNote> writeNote(String title, String content,
			boolean canReply, String privacy) throws DoubanException,
			IOException;

	DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content) throws DoubanException, IOException;

	DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content, boolean canReply) throws DoubanException,
			IOException;

	DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content, boolean canReply, String privacy)
			throws DoubanException, IOException;

	// 日记回复
	DoubanResponse<DoubanComments> getNoteComments(long noteId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanComments> getNoteComments(long noteId, int count)
			throws DoubanException, IOException;

	DoubanResponse<DoubanComments> getNoteComments(long noteId, int count,
			int start) throws DoubanException, IOException;

	DoubanResponse<DoubanComment> addNoteComment(long noteId, String text)
			throws DoubanException, IOException;

	DoubanResponse<DoubanComment> getNoteComment(long noteId, long commentId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanComment> deleteNoteComment(long noteId, long commentId)
			throws DoubanException, IOException;

}
