/**
 * 
 */
package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpStatus;
import org.mcxiaoke.commons.http.StatusCodes;
import org.mcxiaoke.douban.DoubanErrorCode;
import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanComments;
import org.mcxiaoke.douban.api.model.DoubanNote;
import org.mcxiaoke.douban.api.model.DoubanNotes;
import org.mcxiaoke.douban.api.model.DoubanUser;

/**
 * @author mcxiaoke
 * 
 */
public class NotesResourcesTestCase extends BaseApiTestCase {

	/**
	 * 
	 * 获取用户创建的日记列表
	 * 
	 * @throws DoubanException
	 * @throws IOException
	 */

	public void IGNOREtestGetNotesUserCreatedById() throws DoubanException,
			IOException {
		long id = 3950606;
		DoubanResponse<DoubanNotes> res = api.getNotesUserCreated(String
				.valueOf(id));
		error(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNotes notes = res.getData();
		assertNotNull(notes);
		DoubanUser user = notes.getUser();
		assertNotNull(user);
		assertEquals(id, user.getId());
	}

	public void IGNOREtestGetNotesUserCreatedByName() throws DoubanException,
			IOException {
		// TODO
		// 为什么使用ID可以，使用UID不行？，返回400
		String name = "meiyang";
		DoubanResponse<DoubanNotes> res = api.getNotesUserCreated(name);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNotes notes = res.getData();
		assertNotNull(notes);
		DoubanUser user = notes.getUser();
		assertNotNull(user);
		assertEquals(name, user.getUid());
	}

	public void IGNOREtestGetNotesUserCreatedCount() throws DoubanException,
			IOException {
		long id = 3950606;
		int count = 5;
		DoubanResponse<DoubanNotes> res = api.getNotesUserCreated(
				String.valueOf(id), count, null);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNotes notes = res.getData();
		assertNotNull(notes);
		assertNotNull(notes.getNotes());
		assertEquals(count, notes.getData().size());
		DoubanUser user = notes.getUser();
		assertNotNull(user);
		assertEquals(id, user.getId());
	}

	/**
	 * 
	 * 获取用户喜欢的日记列表
	 */
	public void IGNOREtestGetNotesUserLikedById() throws DoubanException,
			IOException {
		long id = 3950606;
		DoubanResponse<DoubanNotes> res = api.getNotesUserLiked(String
				.valueOf(id));
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNotes notes = res.getData();
		assertNotNull(notes);
		DoubanUser user = notes.getUser();
		assertNotNull(user);
		assertEquals(id, user.getId());
	}

	public void IGNOREtestGetNotesUserLikedByName() throws DoubanException,
			IOException {
		// TODO
		// 为什么使用ID可以，使用UID不行？，返回400
		String name = "meiyang";
		DoubanResponse<DoubanNotes> res = api.getNotesUserLiked(name);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNotes notes = res.getData();
		assertNotNull(notes);
		DoubanUser user = notes.getUser();
		assertNotNull(user);
		assertEquals(name, user.getUid());
	}

	public void IGNOREtestGetNotesUserLikedCount() throws DoubanException,
			IOException {
		// count参数不起作用？
		long id = 1376127;
		int count = 5;
		DoubanResponse<DoubanNotes> res = api.getNotesUserLiked(
				String.valueOf(id), count, null);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNotes notes = res.getData();
		assertNotNull(notes);
		assertNotNull(notes.getNotes());
		// assertEquals(count, notes.getData().size());
		DoubanUser user = notes.getUser();
		assertNotNull(user);
		assertEquals(id, user.getId());
	}

	/**
	 * 单条日记操作
	 * 
	 * @throws IOException
	 * @throws DoubanException
	 */
	public void IGNOREtestGetNoteNormal() throws DoubanException, IOException {
		long id = 267415370L;
		DoubanResponse<DoubanNote> res = api.getNote(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNote note = res.getData();
		assertNotNull(note);
		assertEquals(id, note.getId());
	}

	public void IGNOREtestGetNoteNotExists() throws DoubanException,
			IOException {
		// TODO
		// 不存在的为什么返回400而不是404?
		long id = 999999999L;
		DoubanResponse<DoubanNote> res = api.getNote(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_BAD_REQUEST, res.getStatusCode());
		DoubanNote note = res.getData();
		assertNull(note);
	}

	/**
	 * 删除操作
	 * 
	 * @throws DoubanException
	 * @throws IOException
	 */

	public void IGNOREtestDeleteNoteNormal() throws DoubanException,
			IOException {
		long id = 268764974;
		DoubanResponse<DoubanNote> res = api.delete(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
	}

	public void IGNOREtestDeleteNoteNoPermission() throws DoubanException,
			IOException {
		long id = 267415370L;
		DoubanResponse<DoubanNote> res = api.delete(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_FORBIDDEN, res.getStatusCode());
		DoubanNote note = res.getData();
		assertNull(note);
	}

	public void IGNOREtestDeleteNoteNotExists() throws DoubanException,
			IOException {
		// TODO
		// 不存在的为什么返回400而不是404?
		long id = 999999999L;
		DoubanResponse<DoubanNote> res = api.delete(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_BAD_REQUEST, res.getStatusCode());
		DoubanNote note = res.getData();
		assertNull(note);
	}

	/**
	 * 
	 * 喜欢操作
	 */
	public void IGNOREtestLikeNoteNormal() throws DoubanException, IOException {
		long id = 268755370;
		DoubanResponse<DoubanNote> res = api.likeNote(id);
		debug(res);
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
	}

	public void IGNOREtestLikeNoteNotExists() throws DoubanException,
			IOException {
		// TODO
		// 不存在的为什么返回400而不是404?
		long id = 999999999L;
		DoubanResponse<DoubanNote> res = api.likeNote(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_BAD_REQUEST, res.getStatusCode());
		DoubanNote note = res.getData();
		assertNull(note);
	}

	/**
	 * 取消喜欢操作
	 * 
	 */
	public void IGNOREtestUnlikeNoteNormal() throws DoubanException,
			IOException {
		long id = 268755370;
		DoubanResponse<DoubanNote> res = api.unlikeNote(id);
		debug(res);
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
	}

	public void IGNOREtestUnlikeNoteNotExists() throws DoubanException,
			IOException {
		// TODO
		// 不存在的为什么返回400而不是404?
		long id = 999999999L;
		DoubanResponse<DoubanNote> res = api.unlikeNote(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_BAD_REQUEST, res.getStatusCode());
		DoubanNote note = res.getData();
		assertNull(note);
	}

	/**
	 * 
	 * 发布日记
	 * 
	 * @throws IOException
	 * @throws DoubanException
	 */

	public void IGNOREtestWriteNote() throws DoubanException, IOException {
		String title = "Note For Test";
		String content = "Note content for test. ";
		boolean canReply = false;
		String privacy = "private";
		DoubanResponse<DoubanNote> res = api.writeNote(title, content,
				canReply, privacy);
		debug(res);
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNote note = res.getData();
		assertNotNull(note);
		assertEquals(title, note.getTitle());
		assertEquals(content, note.getContent());
		assertEquals(privacy, note.getPrivacy());
		assertEquals(canReply, note.isCanReply());
	}

	public void IGNOREtestUpdateNote() throws DoubanException, IOException {
		// TODO 返回的JSON好像有问题，解析错误
		long id = 268767842;
		String title = "Note For Test Updated." + System.currentTimeMillis();
		String content = "Note content for test. Updated."
				+ System.currentTimeMillis();
		boolean canReply = true;
		String privacy = "friend";
		DoubanResponse<DoubanNote> res = api.updateNote(268767842, title,
				content, canReply, privacy);
		error(res.getRawContent());
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanNote note = res.getData();
		assertNotNull(note);
		assertEquals(id, note.getId());
		assertEquals(title, note.getTitle());
		assertEquals(content, note.getContent());
		assertEquals(privacy, note.getPrivacy());
		assertEquals(canReply, note.isCanReply());
	}

	/**
	 * 日记评论
	 * 
	 * @throws IOException
	 * @throws DoubanException
	 */
	public void IGNOREtestGetNoteCommentsNormal() throws DoubanException,
			IOException {
		long id = 268774232;
		int count = 5;
		DoubanResponse<DoubanComments> res = api.getNoteComments(id, count);
		debug(res);
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanComments dc = res.getData();
		assertNotNull(dc);
		assertNotNull(dc.getComments());
		assertEquals(count, dc.getComments().size());
	}

	public void IGNOREtestGetNoteCommentsNoComments() throws DoubanException,
			IOException {
		long id = 268755370;
		int count = 5;
		DoubanResponse<DoubanComments> res = api.getNoteComments(id, count);
		debug(res);
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanComments dc = res.getData();
		assertNotNull(dc);
		assertTrue(dc.getComments() == null || dc.getComments().isEmpty());
	}

	public void IGNOREtestGetNoteCommentsIdNotExists() throws DoubanException,
			IOException {
		// should be 404 ,why 400?
		long id = 2268755370L;
		int count = 5;
		DoubanResponse<DoubanComments> res = api.getNoteComments(id, count);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_BAD_REQUEST, res.getStatusCode());
		DoubanComments dc = res.getData();
		assertNull(dc);
	}

	/**
	 * 
	 * 添加日记评论
	 * 
	 * @throws IOException
	 * @throws DoubanException
	 */
	public void IGNOREtestAddNoteCommentNormal() throws DoubanException, IOException {
		long id = 268774232;
		String text = "comment " + new Date();
		DoubanResponse<DoubanComment> res = api.addNoteComment(id, text);
		error(res);
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanComment dc = res.getData();
		assertNotNull(dc);
		assertEquals(text, dc.getContent());
	}

	public void IGNOREtestAddNoteCommentCannotReply() throws DoubanException,
			IOException {
		long id = 268755370;
		// http://www.douban.com/note/268755370/
		String text = "" + new Date();
		DoubanResponse<DoubanComment> res = api.addNoteComment(id, text);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_BAD_REQUEST, res.getStatusCode());
	}

	public void IGNOREtestAddNoteCommentIdNotExists() throws DoubanException,
			IOException {
		// should be 404
		long id = 2687742322L;
		String text = "" + new Date();
		DoubanResponse<DoubanComment> res = api.addNoteComment(id, text);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_BAD_REQUEST, res.getStatusCode());
	}

	/**
	 * 
	 * 删除日记评论
	 */
	public void IGNOREtestDeleteNoteCommentNormal() throws DoubanException,
			IOException {
		long id = 268767842;
		long cid = 33186383;
		DoubanResponse<DoubanComment> res = api.deleteNoteComment(id, cid);
		debug(res);
		assertNotNull(res);
		assertTrue(StatusCodes.isSuccess(res.getStatusCode()));
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
	}

	public void IGNOREtestDeleteNoteCommentCommentIdNotExists()
			throws DoubanException, IOException {
		long id = 268767842;
		long cid = 331863832;
		DoubanResponse<DoubanComment> res = api.deleteNoteComment(id, cid);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
	}

}
