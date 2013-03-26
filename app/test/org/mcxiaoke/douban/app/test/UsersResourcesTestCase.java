package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpStatus;
import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanUser;

public class UsersResourcesTestCase extends BaseApiTestCase {

	public void IGNOREtestGetUserInfoById() throws IOException, DoubanException {
		DoubanResponse<DoubanUser> res = api.getUserInfo(String
				.valueOf(1376127));
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
		DoubanUser user = res.getData();
		assertEquals(user.getUid(), "mcxiaoke");
		assertEquals(user.getId(), 1376127);
	}

	public void IGNOREtestGetUserInfoByName() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.getUserInfo("mcxiaoke");
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
		DoubanUser user = res.getData();
		assertEquals(user.getUid(), "mcxiaoke");
		assertEquals(user.getId(), 1376127);
	}

	public void IGNOREtestGetAuthorizedUserInfo() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.getAuthorizedUserInfo();
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
		DoubanUser user = res.getData();
		assertEquals(user.getUid(), "mcxiaoke");
		assertEquals(user.getId(), 1376127);
	}

	public void IGNOREtestFollowUserById() throws IOException, DoubanException {
		// 48737437
		DoubanResponse<DoubanUser> res = api.followUser(String
				.valueOf(48737437));
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void IGNOREtestFollowUserByName() throws IOException,
			DoubanException {
		// 48737437
		DoubanResponse<DoubanUser> res = api.followUser("duxiaoming");
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void IGNOREtestUnfollowUserById() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.unfollowUser(String
				.valueOf(48737437));
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void IGNOREtestUnfollowUserByName() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.unfollowUser("duxiaoming");
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void IGNOREtestFollowUserNotExistsById() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.followUser(String
				.valueOf(487374373));
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());

	}

	public void IGNOREtestFollowUserNotExistsByName() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.followUser("mcxiaoke123");
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());
	}

	public void IGNOREtestUnfollowUserNotExistsById() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.unfollowUser(String
				.valueOf(487374373));
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());

	}

	public void IGNOREtestUnfollowUserNotExistsByName() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.unfollowUser("mcxiaoke123");
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());
	}

	public void IGNOREtestBlockUserById() throws IOException, DoubanException {
		// always return http 400, error 107 invalid_request_uri
		DoubanResponse<DoubanUser> res = api.blockUser(String
				.valueOf(Mock.TEST_USER_ID));
		debug(res);
		assertNotNull(res);
	}

	public void IGNOREtestBlockUserByName() throws IOException, DoubanException {
		// always return http 400, error 107 invalid_request_uri
		DoubanResponse<DoubanUser> res = api.blockUser(Mock.TEST_USER_NAME);
		debug(res);
		assertNotNull(res);
	}

	public void IGNOREtestBlockUserNotExistsById() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api.blockUser(String
				.valueOf(Mock.TEST_USER_ID_NOT_EXISTS));
		debug(res);
		assertNotNull(res);
	}

	public void IGNOREtestBlockUserNotExitstByName() throws IOException,
			DoubanException {
		DoubanResponse<DoubanUser> res = api
				.blockUser(Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
	}

	public void IGNOREtestGetUsersRelationById() throws IOException,
			DoubanException {
		DoubanResponse<DoubanRelation> res = api.getUsersRelation(
				String.valueOf(Mock.TEST_USER_ID_ME),
				String.valueOf(Mock.TEST_USER_ID));
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res.getData());
	}

	public void IGNOREtestGetUsersRelationByName() throws IOException,
			DoubanException {
		DoubanResponse<DoubanRelation> res = api.getUsersRelation(
				Mock.TEST_USER_NAME_ME, Mock.TEST_USER_NAME);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res.getData());
	}

	public void IGNOREtestGetUsersRelationNoSourceIdByName()
			throws IOException, DoubanException {
		DoubanResponse<DoubanRelation> res = api.getUsersRelation("",
				Mock.TEST_USER_NAME);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res.getData());
	}

	public void IGNOREtestGetUsersRelationNotExistsNameByName()
			throws IOException, DoubanException {
		// always return http 500, error -1002
		DoubanResponse<DoubanRelation> res = api.getUsersRelation(
				Mock.TEST_USER_NAME_ME, Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
	}

	public void IGNOREtestSearchUser() throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.searchUser("ahbei");
		debug(res);
		assertNotNull(res);
		assertTrue(res.getData().size() == 1);
	}

	public void IGNOREtestSearchUserByCount() throws IOException,
			DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.searchUser("smile", 40, 0);
		debug(res);
		assertNotNull(res);
		assertTrue(res.getData().size() > 20);
	}

	/***
	 * 
	 * 
	 */

	public void IGNOREtestGetFollowingUsersByNameSmallCount()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.getFollowingUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void IGNOREtestGetFollowingUsersByNameLargeCount()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.getFollowingUsers(
				Mock.TEST_USER_NAME, 30, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(30, res.getData().size());
	}

	public void IGNOREtestGetFollowingUsersByNotExistsName()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api
				.getFollowingUsers(Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNull(res.getData());
	}

	/***
	 * 
	 * 
	 */
	public void IGNOREtestGetFollowersUsersByNameSmallCount()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.getFollowersUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void IGNOREtestGetFollowersUsersByNameLargeCount()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.getFollowersUsers(
				Mock.TEST_USER_NAME, 30, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(30, res.getData().size());
	}

	public void IGNOREtestGetFollowersUsersByNotExistsName()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api
				.getFollowersUsers(Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNull(res.getData());
	}

	/****
	 * 
	 * 
	 * 
	 * 
	 */
	public void IGNOREtestGetFollowInCommonUsersByNameCount()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.getFollowInCommonUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void IGNOREtestGetFollowInCommonUsersByNotExistsName()
			throws IOException, DoubanException {
		DoubanResponse<List<DoubanUser>> res = api
				.getFollowInCommonUsers(Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNull(res.getData());
	}

	/***
	 * 
	 * 
	 * 
	 */
	public void IGNOREtestGetFollowOfUsersByNameCount() throws IOException,
			DoubanException {
		DoubanResponse<List<DoubanUser>> res = api.getFollowingOfUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void IGNOREtestGetFollowOfUsersByNotExistsName() throws IOException,
			DoubanException {
		DoubanResponse<List<DoubanUser>> res = api
				.getFollowingOfUsers(Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNull(res.getData());
	}

}
