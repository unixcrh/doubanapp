/**
 * 
 */
package org.mcxiaoke.douban.app.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanShuo;
import org.mcxiaoke.douban.api.model.DoubanShuoStatus;
import org.mcxiaoke.douban.api.model.DoubanShuoUpdate;
import org.mcxiaoke.douban.api.model.DoubanUser;

import android.test.MoreAsserts;

/**
 * @author mcxiaoke
 * 
 */
public class StatusesResourcesTestCase extends BaseApiTestCase {

	/**
	 * 
	 * 发布一条广播
	 */

	public void IGNOREtestUpdateStatusOnlyText() throws DoubanException,
			IOException {
		final String text = "testUpdateStatusOnlyText " + new Date();
		DoubanShuoUpdate ds = new DoubanShuoUpdate(text);
		DoubanResponse<DoubanShuoStatus> shuo = api.updateStatus(ds);
		debug(shuo);
		assertNotNull(shuo);
		DoubanShuoStatus status = shuo.getData();
		assertNotNull(status);
		assertEquals(text, status.getText());
	}

	public void IGNOREtestUpdateStatusWithImage() throws DoubanException,
			IOException {
		final String text = "testUpdateStatusWithImage " + new Date();
		DoubanShuoUpdate ds = new DoubanShuoUpdate(text, new File(
				"/sdcard/metro.jpg"));
		DoubanResponse<DoubanShuoStatus> shuo = api.updateStatus(ds);
		debug(shuo);
		assertNotNull(shuo);
		DoubanShuoStatus status = shuo.getData();
		assertNotNull(status);
		assertEquals(text, status.getText());
	}

	public void IGNOREtestUpdateStatusWithRec() throws DoubanException,
			IOException {
		final String text = "testUpdateStatusWithRec " + new Date();
		DoubanShuoUpdate ds = new DoubanShuoUpdate(text);
		// ds.setRecTitle("测试推荐");
		ds.setRecUrl("http://read.douban.com/ebook/395295/");
		// ds.setRecDesc("你听见了雨声吗");
		// ds.setRecImageUrl("http://img3.douban.com/view/ark_article_cover/cut/public/395295.jpg");
		DoubanResponse<DoubanShuoStatus> shuo = api.updateStatus(ds);
		debug(shuo);
		assertNotNull(shuo);
		DoubanShuoStatus status = shuo.getData();
		assertNotNull(status);
		assertEquals(text, status.getText());
	}

	/**
	 * 获取一条广播内容
	 * 
	 */

	public void IGNOREtestShowStatusContent() throws DoubanException,
			IOException {
		DoubanResponse<DoubanShuoStatus> res = api
				.showStatusConent(1122677616L);
		debug(res);
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
		assertEquals(1122677616, status.getId());
	}

	public void IGNOREtestShowStatusWithEntries() throws DoubanException,
			IOException {
		DoubanResponse<DoubanShuo> res = api.showStatus(1122677616L, true);
		debug(res);
		assertNotNull(res);
		DoubanShuo shuo = res.getData();
		assertNotNull(shuo);
		assertNotNull(shuo.getReshareUsers());
		assertNotNull(shuo.getLikeUsers());
		assertNotNull(shuo.getComments());
		DoubanShuoStatus status = shuo.getStatus();
		assertNotNull(status);
		assertEquals(1122677616, status.getId());
	}

	public void IGNOREtestShowStatusWithoutEntries() throws DoubanException,
			IOException {
		// if pack=false, reshare users and comments remained, why?
		DoubanResponse<DoubanShuo> res = api.showStatus(1122677616L, false);
		debug(res);
		assertNotNull(res);
		DoubanShuo shuo = res.getData();
		assertNotNull(shuo);
		assertNull(shuo.getComments());
		assertNull(shuo.getReshareUsers());
		assertNull(shuo.getLikeUsers());
		DoubanShuoStatus status = shuo.getStatus();
		assertNotNull(status);
		assertEquals(1122677616, status.getId());
	}

	public void IGNOREtestShowStatusNotExists() throws DoubanException,
			IOException {
		DoubanResponse<DoubanShuo> res = api.showStatus(11226776162L, false);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		DoubanShuo shuo = res.getData();
		assertNull(shuo);
	}

	/**
	 * 
	 * 删除一条广播
	 * 
	 */
	public void IGNOREtestDeleteStatusNormal() throws DoubanException,
			IOException {
		long id = 1122698996L;
		DoubanResponse<DoubanShuoStatus> res = api.deleteStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
		assertEquals(id, status.getId());

	}

	public void IGNOREtestDeleteStatusNotExists() throws DoubanException,
			IOException {
		long id = 8122698996L;
		DoubanResponse<DoubanShuoStatus> res = api.deleteStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNotNull(res);
		// DoubanShuoStatus status=res.getData();
		// assertNotNull(status);
		// assertEquals(id, status.getId());

	}

	public void IGNOREtestDeleteStatusNoPermission() throws DoubanException,
			IOException {
		// cannot delete other's status, why return http code 200?
		long id = 1122795427;
		DoubanResponse<DoubanShuoStatus> res = api.deleteStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);

	}

	/**
	 * 
	 * 获取广播的转发用户
	 */

	public void IGNOREtestGetStatusReshareUsersHas() throws DoubanException,
			IOException {
		long id = 1122786668L;
		DoubanResponse<List<DoubanUser>> res = api.getStatusReshareUsers(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		List<DoubanUser> list = res.getData();
		assertTrue(list.size() > 0);
	}

	public void IGNOREtestGetStatusReshareUsersHasNot() throws DoubanException,
			IOException {
		long id = 1122795427L;
		DoubanResponse<List<DoubanUser>> res = api.getStatusReshareUsers(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		List<DoubanUser> list = res.getData();
		assertTrue(list==null || list.isEmpty());
	}

	/**
	 * 
	 * 转发一条广播
	 */

	public void IGNOREtestReshareStatusNormal() throws DoubanException, IOException {
		long id = 1122823840;
		DoubanResponse<DoubanShuoStatus> res = api.reshareStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
	}

	public void IGNOREtestReshareStatusSelf() throws DoubanException, IOException {
		long id = 1122834262;
		DoubanResponse<DoubanShuoStatus> res = api.reshareStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
	}

	public void IGNOREtestReshareStatusNotExists() throws DoubanException,
			IOException {
		long id = 112282384011L;
		DoubanResponse<DoubanShuoStatus> res = api.reshareStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNull(status);
	}

	/**
	 * 取消转发一条广播
	 * 
	 */
	public void IGNOREtestUnreshareStatusNormal() throws DoubanException, IOException {
		long id = 1122705127;
		DoubanResponse<DoubanShuoStatus> res = api.unreshareStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
	}

	public void IGNOREtestUnreshareStatusSelf() throws DoubanException, IOException {
		long id = 1122705127;
		DoubanResponse<DoubanShuoStatus> res = api.unreshareStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
		assertEquals(id, status.getId());
	}

	public void IGNOREtestUnreshareStatusNotExists() throws DoubanException,
			IOException {
		long id = 112282384011L;
		DoubanResponse<DoubanShuoStatus> res = api.unreshareStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNull(status);
	}

	/**
	 * 获取赞一条广播的用户
	 * 
	 */

	public void IGNOREtestGetStatusLikeUsersHas() throws DoubanException, IOException {
		long id = 1122786279L;
		DoubanResponse<List<DoubanUser>> res = api.getStatusLikeUsers(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		List<DoubanUser> list = res.getData();
		assertTrue(list.size() > 0);
	}

	public void IGNOREtestGetStatusLikeUsersHasNot() throws DoubanException,
			IOException {
		long id = 1122775349L;
		DoubanResponse<List<DoubanUser>> res = api.getStatusLikeUsers(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		List<DoubanUser> list = res.getData();
		assertTrue(list==null || list.isEmpty());
	}

	/**
	 * 
	 * 赞一条广播
	 */
	public void IGNOREtestLikeStatusNormal() throws DoubanException, IOException {
		long id = 1122789210;
		DoubanResponse<DoubanShuoStatus> res = api.likeStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
		assertEquals(id, status.getId());
	}

	public void IGNOREtestLikeStatusNotExists() throws DoubanException, IOException {
		long id = 11227892101L;
		DoubanResponse<DoubanShuoStatus> res = api.likeStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNull(status);
	}

	/**
	 * 
	 * 取消赞一条广播
	 */
	public void IGNOREtestUnlikeStatusNormal() throws DoubanException, IOException {
		long id = 1122775349;
		DoubanResponse<DoubanShuoStatus> res = api.unlikeStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNotNull(status);
		assertEquals(id, status.getId());
	}

	public void IGNOREtestUnlikeStatusNotExists() throws DoubanException, IOException {
		long id = 11227753491L;
		DoubanResponse<DoubanShuoStatus> res = api.unlikeStatus(id);
		debug(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNotNull(res);
		DoubanShuoStatus status = res.getData();
		assertNull(status);
	}

	/**
	 * 
	 * 获取广播的评论列表
	 * 
	 * @throws IOException
	 * @throws DoubanException
	 */
	public void IGNOREtestGetStatusCommentsNormal() throws DoubanException,
			IOException {
		long id = 1122788359L;
		int count = 5;
		DoubanResponse<List<DoubanComment>> res = api.getStatusComments(id,
				count);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		List<DoubanComment> list = res.getData();
		assertNotNull(list);
		assertEquals(count, list.size());
	}

	public void IGNOREtestGetStatusCommentsEmpty() throws DoubanException,
			IOException {
		long id = 1122810633L;
		DoubanResponse<List<DoubanComment>> res = api.getStatusComments(id, 5);
		debug(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res);
		List<DoubanComment> list = res.getData();
		assertTrue(list==null || list.isEmpty());
	}

	public void IGNOREtestGetStatusCommentsStatusIdNotExists()
			throws DoubanException, IOException {
		long id = 9122388111L;
		DoubanResponse<List<DoubanComment>> res = api.getStatusComments(id, 5);
		debug(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNotNull(res);
		List<DoubanComment> list = res.getData();
		assertNull(list);
	}

	/**
	 * 评论一条广播
	 * 
	 */
	public void IGNOREtestAddStatusCommentNormal() throws DoubanException,
			IOException {
		long id = 1122708171L;
		String text = "comment test at " + System.currentTimeMillis();
		DoubanResponse<DoubanComment> res = api.addStatusComment(id, text);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		DoubanComment dc = res.getData();
		assertNotNull(dc);
	}

	public void IGNOREtestAddStatusCommentCannotRreply() throws DoubanException,
			IOException {
		long id = 1122710916L;
		String text = "comment test at " + System.currentTimeMillis();
		DoubanResponse<DoubanComment> res = api.addStatusComment(id, text);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
	}

	public void IGNOREtestAddStatusCommentIdNotExists() throws DoubanException,
			IOException {
		long id = 9122708171L;
		String text = "comment test at " + System.currentTimeMillis();
		DoubanResponse<DoubanComment> res = api.addStatusComment(id, text);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
	}

	/**
	 * 删除广播评论
	 */
	public void IGNOREtestDeleteStatusCommentNormal() throws DoubanException,
			IOException {
		long id = 158865688;
		DoubanResponse<DoubanComment> res = api.deleteStatusComment(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		DoubanComment dc = res.getData();
		assertNotNull(dc);
	}

	public void IGNOREtestDeleteStatusCommentNoPermission() throws DoubanException,
			IOException {
		long id = 0;
		DoubanResponse<DoubanComment> res = api.deleteStatusComment(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
	}

	public void IGNOREtestDeleteStatusCommentNotExists() throws DoubanException,
			IOException {
		long id = 999999999L;
		DoubanResponse<DoubanComment> res = api.deleteStatusComment(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
	}

	/**
	 * 
	 * 获取一条广播评论
	 */
	public void IGNOREtestGetStatusCommentNormal() throws DoubanException,
			IOException {
		long id = 158865847;
		DoubanResponse<DoubanComment> res = api.getStatusComment(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		DoubanComment dc = res.getData();
		assertNotNull(dc);
	}

	public void IGNOREtestGetStatusCommentNotExists() throws DoubanException,
			IOException {
		long id = 1588658471;
		DoubanResponse<DoubanComment> res = api.getStatusComment(id);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
	}

	/**
	 * 
	 * 主页时间线
	 */
	public void IGNOREtestGetHomeTimelineNormal() throws DoubanException, IOException {
		DoubanResponse<List<DoubanShuoStatus>> res = api.getHomeTimeline();
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		List<DoubanShuoStatus> list = res.getData();
		assertNotNull(list);
		assertTrue(list.size() == 20);
	}

	public void IGNOREtestGetHomeTimelineCount() throws DoubanException, IOException {
		DoubanResponse<List<DoubanShuoStatus>> res = api.getHomeTimeline(0, 0,
				5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		List<DoubanShuoStatus> list = res.getData();
		assertNotNull(list);
		assertTrue(list.size() == 5);
	}

	/**
	 *  用户时间线
	 * 
	 */
	public void IGNOREtestGetUserTimelineNormal() throws DoubanException, IOException {
		long id = 57305019L;
		DoubanResponse<List<DoubanShuoStatus>> res = api.getUserTimeline(String
				.valueOf(id));
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		List<DoubanShuoStatus> list = res.getData();
		assertNotNull(list);
		assertTrue(list.size() == 20);
	}

	public void IGNOREtestGetUserTimelineCount() throws DoubanException, IOException {
		String name = "hanifah";
		DoubanResponse<List<DoubanShuoStatus>> res = api.getUserTimeline(name,
				0, 0, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		List<DoubanShuoStatus> list = res.getData();
		assertNotNull(list);
		assertTrue(list.size() == 5);
	}

	public void IGNOREtestGetUserTimelineUserNotExists() throws DoubanException,
			IOException {
		long id = 957305019L;
		DoubanResponse<List<DoubanShuoStatus>> res = api.getUserTimeline(String.valueOf(id));
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		List<DoubanShuoStatus> list = res.getData();
		assertNull(list);
	}

}
