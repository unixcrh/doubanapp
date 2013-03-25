package org.mcxiaoke.douban.app.test;

import java.util.List;

import org.apache.http.HttpStatus;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanUser;
import org.mcxiaoke.douban.api.model.DoubanUsers;

public class UsersResourcesTestCase extends BaseApiTestCase {

	public void atestGetUserInfoById() {
		DoubanResponse<DoubanUser> res = api.getUserInfo(1376127);
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
		DoubanUser user = res.getData();
		assertEquals(user.getUid(), "mcxiaoke");
		assertEquals(user.getId(), 1376127);
	}

	public void atestGetUserInfoByName() {
		DoubanResponse<DoubanUser> res = api.getUserInfo("mcxiaoke");
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
		DoubanUser user = res.getData();
		assertEquals(user.getUid(), "mcxiaoke");
		assertEquals(user.getId(), 1376127);
	}

	public void atestGetAuthorizedUserInfo() {
		DoubanResponse<DoubanUser> res = api.getAuthorizedUserInfo();
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
		DoubanUser user = res.getData();
		assertEquals(user.getUid(), "mcxiaoke");
		assertEquals(user.getId(), 1376127);
	}

	public void atestFollowUserById() {
		// 48737437
		DoubanResponse<DoubanUser> res = api.followUser(48737437);
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void atestFollowUserByName() {
		// 48737437
		DoubanResponse<DoubanUser> res = api.followUser("duxiaoming");
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void atestUnfollowUserById() {
		DoubanResponse<DoubanUser> res = api.unfollowUser(48737437);
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void atestUnfollowUserByName() {
		DoubanResponse<DoubanUser> res = api.unfollowUser("duxiaoming");
		debug(res);
		assertNotNull(res);
		assertNotNull(res.getData());
	}

	public void atestFollowUserNotExistsById() {
		DoubanResponse<DoubanUser> res = api.followUser(487374373);
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());

	}

	public void atestFollowUserNotExistsByName() {
		DoubanResponse<DoubanUser> res = api.followUser("mcxiaoke123");
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());
	}

	public void atestUnfollowUserNotExistsById() {
		DoubanResponse<DoubanUser> res = api.unfollowUser(487374373);
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());

	}

	public void atestUnfollowUserNotExistsByName() {
		DoubanResponse<DoubanUser> res = api.unfollowUser("mcxiaoke123");
		debug(res);
		assertNotNull(res);
		assertNull(res.getData());
	}

	public void atestBlockUserById() {
		// always return http 400, error 107 invalid_request_uri
		DoubanResponse<DoubanUser> res = api.blockUser(Mock.TEST_USER_ID);
		debug(res);
		assertNotNull(res);
	}

	public void atestBlockUserByName() {
		// always return http 400, error 107 invalid_request_uri
		DoubanResponse<DoubanUser> res = api.blockUser(Mock.TEST_USER_NAME);
		debug(res);
		assertNotNull(res);
	}

	public void atestBlockUserNotExistsById() {
		DoubanResponse<DoubanUser> res = api
				.blockUser(Mock.TEST_USER_ID_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
	}

	public void atestBlockUserNotExitstByName() {
		DoubanResponse<DoubanUser> res = api
				.blockUser(Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
	}

	public void atestGetUsersRelationById() {
		DoubanResponse<DoubanRelation> res = api.getUsersRelation(
				Mock.TEST_USER_ID_ME, Mock.TEST_USER_ID);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res.getData());
	}

	public void atestGetUsersRelationByName() {
		DoubanResponse<DoubanRelation> res = api.getUsersRelation(
				Mock.TEST_USER_NAME_ME, Mock.TEST_USER_NAME);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res.getData());
	}

	public void atestGetUsersRelationNoSourceIdByName() {
		DoubanResponse<DoubanRelation> res = api.getUsersRelation("",
				Mock.TEST_USER_NAME);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertNotNull(res.getData());
	}

	public void atestGetUsersRelationNotExistsNameByName() {
		// always return http 500, error -1002
		DoubanResponse<DoubanRelation> res = api.getUsersRelation(
				Mock.TEST_USER_NAME_ME, Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
	}

	public void atestSearchUser() {
		DoubanResponse<List<DoubanUser>> res = api.searchUser("ahbei");
		debug(res);
		assertNotNull(res);
		assertTrue(res.getData().size() == 1);
	}

	public void atestSearchUserByCount() {
		DoubanResponse<List<DoubanUser>> res = api.searchUser("smile", 40, 0);
		debug(res);
		assertNotNull(res);
		assertTrue(res.getData().size() > 20);
	}

	/***
	 * 
	 * 
	 */

	public void atestGetFollowingUsersByNameSmallCount() {
		DoubanResponse<List<DoubanUser>> res = api.getFollowingUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void atestGetFollowingUsersByNameLargeCount() {
		DoubanResponse<List<DoubanUser>> res = api.getFollowingUsers(
				Mock.TEST_USER_NAME, 30, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(30, res.getData().size());
	}

	public void atestGetFollowingUsersByNotExistsName() {
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
	public void atestGetFollowersUsersByNameSmallCount() {
		DoubanResponse<List<DoubanUser>> res = api.getFollowersUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void atestGetFollowersUsersByNameLargeCount() {
		DoubanResponse<List<DoubanUser>> res = api.getFollowersUsers(
				Mock.TEST_USER_NAME, 30, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(30, res.getData().size());
	}

	public void atestGetFollowersUsersByNotExistsName() {
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
	public void atestGetFollowInCommonUsersByNameCount() {
		DoubanResponse<List<DoubanUser>> res = api.getFollowInCommonUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void atestGetFollowInCommonUsersByNotExistsName() {
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
	public void testGetFollowOfUsersByNameCount() {
		DoubanResponse<List<DoubanUser>> res = api.getFollowingOfUsers(
				Mock.TEST_USER_NAME, 5, 0);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(5, res.getData().size());
	}

	public void testGetFollowOfUsersByNotExistsName() {
		DoubanResponse<List<DoubanUser>> res = api
				.getFollowingOfUsers(Mock.TEST_USER_NAME_NOT_EXISTS);
		debug(res);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		assertNull(res.getData());
	}

}
