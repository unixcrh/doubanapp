/**
 * 
 */
package org.mcxiaoke.douban;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mcxiaoke.commons.auth.Authorization;
import org.mcxiaoke.commons.auth.SignatureStyle;
import org.mcxiaoke.commons.http.HttpMethod;
import org.mcxiaoke.commons.http.SimpleClient;
import org.mcxiaoke.commons.http.SimpleRequest;
import org.mcxiaoke.commons.http.SimpleResponse;
import org.mcxiaoke.commons.util.AssertUtils;
import org.mcxiaoke.commons.util.StringUtils;
import org.mcxiaoke.douban.api.model.DoubanAlbum;
import org.mcxiaoke.douban.api.model.DoubanAlbumPhotos;
import org.mcxiaoke.douban.api.model.DoubanAlbums;
import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanComments;
import org.mcxiaoke.douban.api.model.DoubanNote;
import org.mcxiaoke.douban.api.model.DoubanNotes;
import org.mcxiaoke.douban.api.model.DoubanPhoto;
import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanShuo;
import org.mcxiaoke.douban.api.model.DoubanShuoStatus;
import org.mcxiaoke.douban.api.model.DoubanShuoUpdate;
import org.mcxiaoke.douban.api.model.DoubanUser;
import org.scribe.model.OAuthToken;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanApiClientImpl implements DoubanApiClient {
	private static final boolean DEBUG = DoubanConfig.DEBUG;
	private static final String TAG = "DoubanApiClient";

	private static final String SCHEME_HTTP = "http://";
	private static final String SCHEME_HTTPS = "https://";
	private static final String API_HOST = DoubanConfig.API_HOST;

	private Context mContext;
	private SimpleClient mClient;
	private DoubanSession mSession;

	private static void debug(Object object) {
		Log.d(TAG, "[DEBUG] " + object);
	}

	public DoubanApiClientImpl(Context context, DoubanSession session) {
		AssertUtils.notNull(context,
				"context must not be null, suggested use ApplicationContext.");
		AssertUtils.notNull(session, "session must not be null.");
		this.mContext = context.getApplicationContext();
		this.mClient = new SimpleClient(this.mContext);
		this.mSession = session;
	}

	@Override
	public String getAuthorizeUrl() {
		return mSession.getAuthorizeUrl();
	}

	@Override
	public OAuthToken login(String authorizeCode) {
		return mSession.getAccessTokenByCode();
	}

	@Override
	public OAuthToken login(String userName, String password) {
		return mSession.getAccessTokenByCredentials();
	}

	@Override
	public OAuthToken relogin(String refreshToken) {
		return mSession.getAccessTokenByRefreshToken();
	}

	private Authorization getAuthorizationFromSession() {
		if (mSession.isSessionValid()) {
			final Authorization authorization = new Authorization(
					Authorization.OAUTH2);
			authorization.setSignatureStyle(SignatureStyle.HEADER_BEARER);
			authorization.setApiKey(mSession.getApiKey());
			authorization.setApiSecret(mSession.getApiSecret());
			authorization.setToken(mSession.getToken());
			authorization.setSecret(mSession.getSecret());
			return authorization;
		} else {
			return null;
		}
	}

	private String checkUrl(String path) {
		if (path.startsWith(SCHEME_HTTPS) || path.startsWith(SCHEME_HTTP)) {
			return path;
		} else {
			return API_HOST.concat(path);
		}
	}

	private SimpleRequest constructRequest(HttpMethod method, String path,
			Map<String, String> params) {
		String url = checkUrl(path);
		SimpleRequest request = new SimpleRequest(url, method);
		if (params != null && params.size() > 0) {
			request.addParameters(params);
		}
		final Authorization authorization = getAuthorizationFromSession();
		if (authorization != null) {
			request.setAuthorization(authorization);
		}
		return request;
	}

	private SimpleResponse executeBodyRequest(HttpMethod method, String path,
			Map<String, String> params, String name, File file)
			throws DoubanException, IOException {
		AssertUtils.isTrue(HttpMethod.POST == method
				|| HttpMethod.PUT == method,
				" request with body must use post or put");
		AssertUtils.notEmpty(path,
				"request api path must not be null or empty.");
		AssertUtils.notEmpty(name,
				"file parameter name must not be null or empty.");
		AssertUtils.notNull(file, "file must not be null.");
		final SimpleRequest request = constructRequest(method, path, params);
		request.addParameter(name, file);
		if (DEBUG) {
			debug("executeBodyRequest, request= " + request);
		}
		SimpleResponse response = mClient.execute(request);
		if (DEBUG) {
			debug("executeBodyRequest, response= " + response.getStatusCode()
					+ " " + response);
		}
		return response;
	}

	private SimpleResponse executeNormalRequest(HttpMethod method, String path,
			Map<String, String> params) throws DoubanException, IOException {
		AssertUtils.notNull(method, "http method must not be null.");
		AssertUtils.notEmpty(path, "request api path must not be null. ");
		final SimpleRequest request = constructRequest(method, path, params);
		if (DEBUG) {
			debug("executeNormalRequest, request= " + request);
		}
		SimpleResponse response = mClient.execute(request);
		if (DEBUG) {
			debug("executeNormalRequest, response= " + response.getStatusCode()
					+ " " + response);
		}
		return response;
	}

	private SimpleResponse doPost(String path, Map<String, String> params,
			String name, File file) throws FileNotFoundException,
			DoubanException, IOException {
		AssertUtils.notNull(file, " file parameter must not be null.");
		return executeBodyRequest(HttpMethod.POST, path, params, name, file);
	}

	private SimpleResponse doPost(String path, Map<String, String> params)
			throws DoubanException, IOException {
		return executeNormalRequest(HttpMethod.POST, path, params);
	}

	private SimpleResponse doPost(String path) throws DoubanException,
			IOException {
		return doPost(path, null);
	}

	private SimpleResponse doPut(String path, Map<String, String> params)
			throws DoubanException, IOException {
		return executeNormalRequest(HttpMethod.PUT, path, params);
	}

	private SimpleResponse doPut(String path) throws DoubanException,
			IOException {
		return doPut(path, null);
	}

	private SimpleResponse doDelete(String path, Map<String, String> params)
			throws DoubanException, IOException {
		return executeNormalRequest(HttpMethod.DELETE, path, params);
	}

	private SimpleResponse doDelete(String path) throws DoubanException,
			IOException {
		return doDelete(path, null);
	}

	private SimpleResponse doGet(String path, Map<String, String> params)
			throws DoubanException, IOException {
		return executeNormalRequest(HttpMethod.GET, path, params);
	}

	private SimpleResponse doGet(String path) throws DoubanException,
			IOException {
		return doGet(path, null);
	}

	public <T> DoubanResponse<T> parse(final SimpleResponse response,
			final Object type) throws DoubanException, IOException {
		return new DoubanResponse<T>(response, type);
	}

	private static String getApiPath(String format, Object... args) {
		return String.format(format, args);
	}

	/**
	 * 
	 * 以下是豆瓣API的各种REST操作
	 * 
	 */

	/**
	 * 通用评论API 产品代码： statuses/note/photo
	 */

	private DoubanResponse<DoubanComments> getComments(String target,
			long targetId) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.COMMENTS, target, targetId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanComments.class);
	}

	private DoubanResponse<DoubanComment> getComment(String target,
			long targetId, long commentId) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.COMMENT, target, targetId,
				commentId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanComment.class);
	}

	private DoubanResponse<DoubanComment> deleteComment(String target,
			long targetId, long commentId) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.COMMENT, target, targetId,
				commentId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanComment.class);
	}

	private DoubanResponse<DoubanComment> addComment(String target,
			long targetId, String text) throws DoubanException, IOException {
		AssertUtils.notEmpty(text,
				"photo comment text must not be null or empty. ");
		String path = getApiPath(DoubanConfig.Path.COMMENT, target, targetId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.TEXT, text);
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanComment.class);
	}

	/**
	 * 用户信息相关操作
	 */

	@Override
	public DoubanResponse<DoubanUser> getUserInfo(String userName)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USER, userName);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> getAuthorizedUserInfo()
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USER_ME);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> followUser(String userName)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USER_FOLLOW);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.USER_ID, userName);
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> unfollowUser(String userName)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USER_UNFOLLOW);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.USER_ID, userName);
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> blockUser(String userName)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USER_BLOCK, userName);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.USER_ID, userName);
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> unblockUser(String userName)
			throws DoubanException, IOException {
		throw new UnsupportedOperationException(
				"unblock operation is now unsupported.");
	}

	@Override
	public DoubanResponse<DoubanRelation> getUsersRelation(String sourceName,
			String targetName) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USER_FRIENDSHIP);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.SOURCE_ID, sourceName);
		params.put(DoubanConfig.Key.TARGET_ID, targetName);
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanRelation.class);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> searchUser(String query)
			throws DoubanException, IOException {
		return searchUser(query, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> searchUser(String query, int count,
			int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USERS_SEARCH);
		Map<String, String> params = new HashMap<String, String>(3);
		params.put(DoubanConfig.Key.QUERY, query);
		params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		params.put(DoubanConfig.Key.START, String.valueOf(start));
		SimpleResponse response = doGet(path, params);
		return parse(response, new TypeReference<List<DoubanUser>>() {
		});
	}

	private DoubanResponse<List<DoubanUser>> getRelatedUsers(String path,
			int count, int start) throws DoubanException, IOException {
		Map<String, String> params = new HashMap<String, String>(3);
		params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		params.put(DoubanConfig.Key.START, String.valueOf(start));
		SimpleResponse response = doGet(path, params);
		return parse(response, new TypeReference<List<DoubanUser>>() {
		});
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName)
			throws DoubanException, IOException {
		return getFollowingUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName,
			int count, int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOWING, userName);
		return getRelatedUsers(path, count, start);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName)
			throws DoubanException, IOException {
		return getFollowersUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName,
			int count, int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOWERS, userName);
		return getRelatedUsers(path, count, start);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(
			String userName) throws DoubanException, IOException {
		return getFollowInCommonUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(
			String userName, int count, int start) throws DoubanException,
			IOException {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOW_IN_COMMON,
				userName);
		return getRelatedUsers(path, count, start);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName)
			throws DoubanException, IOException {
		return getFollowingOfUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingOfUsers(
			String userName, int count, int start) throws DoubanException,
			IOException {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOW_ALSO, userName);
		return getRelatedUsers(path, count, start);
	}

	/*******************************************************************************************
	 * *************************************************************************
	 * **************** 豆瓣广播的相关操作
	 ******************************************************************************************* 
	 * *****************************************************************************************/

	/**
	 * 发布一条广播
	 */
	@Override
	public DoubanResponse<DoubanShuoStatus> updateStatus(DoubanShuoUpdate status)
			throws DoubanException, IOException {
		AssertUtils.notNull(status,
				"shuo status update object must not be null.");
		AssertUtils.notEmpty(status.getText());
		String path = getApiPath(DoubanConfig.Path.STATUSES);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		params.put(DoubanConfig.Key.TEXT, status.getText());
		String recTitle = status.getRecTitle();
		String recUrl = status.getRecUrl();
		String recDesc = status.getRecDesc();
		String recImage = status.getRecImageUrl();
		if (StringUtils.isNotEmpty(recTitle)) {
			params.put(DoubanConfig.Key.REC_TITLE, recTitle);
		}
		if (StringUtils.isNotEmpty(recUrl)) {
			params.put(DoubanConfig.Key.REC_URL, recTitle);
		}
		if (StringUtils.isNotEmpty(recDesc)) {
			params.put(DoubanConfig.Key.REC_DESC, recDesc);
		}
		if (StringUtils.isNotEmpty(recImage)) {
			params.put(DoubanConfig.Key.REC_IMAGE, recImage);
		}

		SimpleResponse response;
		if (status.hasImage()) {
			response = doPost(path, params, DoubanConfig.Key.IMAGE,
					status.getImage());
		} else {
			response = doPost(path, params);
		}
		return parse(response, DoubanShuoStatus.class);
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> updateStatus(String text)
			throws DoubanException, IOException {
		return updateStatus(new DoubanShuoUpdate(text));
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> updateStatus(String text, File image)
			throws DoubanException, IOException {
		return updateStatus(new DoubanShuoUpdate(text, image));
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> updateStatus(String text,
			String title, String url, String desc) throws DoubanException,
			IOException {
		return updateStatus(text, title, url, desc, null);
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> updateStatus(String text,
			String title, String url, String desc, String imageUrl)
			throws DoubanException, IOException {
		DoubanShuoUpdate status = new DoubanShuoUpdate(text);
		status.setRecTitle(title);
		status.setRecUrl(url);
		status.setRecDesc(desc);
		status.setRecImageUrl(imageUrl);
		return updateStatus(status);
	}

	/**
	 * 获取一条消息
	 */
	@Override
	public DoubanResponse<DoubanShuoStatus> showStatusConent(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS, statusId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanShuoStatus.class);
	}

	@Override
	public DoubanResponse<DoubanShuo> showStatus(long statusId, boolean pack)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS, statusId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.PACK, String.valueOf(pack));
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanShuo.class);
	}

	/**
	 * 删除一条消息
	 */
	@Override
	public DoubanResponse<DoubanShuoStatus> deleteStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS, statusId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanShuoStatus.class);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getStatusReshareUsers(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_RESHARE, statusId);
		SimpleResponse response = doGet(path);
		return parse(response, new TypeReference<List<DoubanUser>>() {
		});
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> reshareStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_RESHARE, statusId);
		SimpleResponse response = doPost(path);
		return parse(response, DoubanShuoStatus.class);
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> unreshareStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS, statusId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanShuoStatus.class);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getStatusLikeUsers(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_LIKE, statusId);
		SimpleResponse response = doGet(path);
		return parse(response, new TypeReference<List<DoubanUser>>() {
		});
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> likeStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_LIKE, statusId);
		SimpleResponse response = doPost(path);
		return parse(response, DoubanShuoStatus.class);
	}

	@Override
	public DoubanResponse<DoubanShuoStatus> unlikeStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_LIKE, statusId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanShuoStatus.class);
	}

	@Override
	public DoubanResponse<List<DoubanComment>> getStatusComments(long statusId)
			throws DoubanException, IOException {
		return getStatusComments(statusId, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanComment>> getStatusComments(long statusId,
			int count) throws DoubanException, IOException {
		return getStatusComments(statusId, count, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanComment>> getStatusComments(long statusId,
			int count, int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_COMMENTS, statusId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		params.put(DoubanConfig.Key.START, String.valueOf(start));
		SimpleResponse response = doGet(path, params);
		return parse(response, new TypeReference<List<DoubanComment>>() {
		});
	}

	@Override
	public DoubanResponse<DoubanComment> addStatusComment(long statusId,
			String text) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_COMMENTS, statusId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.CONTENT, text);
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanComment.class);
	}

	@Override
	public DoubanResponse<DoubanComment> deleteStatusComment(long commentId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_COMMENT, commentId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanComment.class);
	}

	@Override
	public DoubanResponse<DoubanComment> getStatusComment(long commentId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_COMMENT, commentId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanComment.class);
	}

	private DoubanResponse<List<DoubanShuoStatus>> getTimeline(String path,
			long sinceId, long maxId, int count, int start)
			throws DoubanException, IOException {
		Map<String, String> params = new HashMap<String, String>();
		if (sinceId > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.SINCE_ID, String.valueOf(sinceId));
		}
		if (maxId > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.MAX_ID, String.valueOf(maxId));
		}
		params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		params.put(DoubanConfig.Key.START, String.valueOf(start));
		SimpleResponse response = doGet(path, params);
		return parse(response, new TypeReference<List<DoubanShuoStatus>>() {
		});
	}

	/**
	 * Home时间线
	 */
	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline()
			throws DoubanException, IOException {
		return getHomeTimeline(DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId)
			throws DoubanException, IOException {
		return getHomeTimeline(sinceId, DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId,
			long maxId) throws DoubanException, IOException {
		return getHomeTimeline(sinceId, maxId, DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId,
			long maxId, int count) throws DoubanException, IOException {
		return getHomeTimeline(sinceId, maxId, count,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getHomeTimeline(long sinceId,
			long maxId, int count, int start) throws DoubanException,
			IOException {
		String path = getApiPath(DoubanConfig.Path.STATUSES_HOME);
		return getTimeline(path, sinceId, maxId, count, start);
	}

	/**
	 * 用户时间线
	 */
	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(
			String userName) throws DoubanException, IOException {
		return getUserTimeline(userName, DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(
			String userName, long sinceId) throws DoubanException, IOException {
		return getUserTimeline(userName, sinceId, DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(
			String userName, long sinceId, long maxId) throws DoubanException,
			IOException {
		return getUserTimeline(userName, sinceId, maxId,
				DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(
			String userName, long sinceId, long maxId, int count)
			throws DoubanException, IOException {
		return getUserTimeline(userName, sinceId, maxId, count,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanShuoStatus>> getUserTimeline(
			String userName, long sinceId, long maxId, int count, int start)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUSES_USER, userName);
		return getTimeline(path, sinceId, maxId, count, start);
	}

	/**
	 * 
	 * 豆瓣日记
	 */
	private DoubanResponse<DoubanNotes> getNotes(String path, String format,
			int count, int start) throws DoubanException, IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.FORMAT,
				StringUtils.isEmpty(format) ? DoubanConfig.NOTE_FORMAT_TEXT
						: format);
		if (count > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		}
		if (start > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.START, String.valueOf(start));
		}
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanNotes.class);
	}

	/**
	 * 用户创建的日记
	 */

	@Override
	public DoubanResponse<DoubanNotes> getNotesUserCreated(String userName)
			throws DoubanException, IOException {
		return getNotesUserCreated(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.NOTE_FORMAT_TEXT);
	}

	@Override
	public DoubanResponse<DoubanNotes> getNotesUserCreated(String userName,
			int count, String format) throws DoubanException, IOException {
		return getNotesUserCreated(userName, count, DoubanConfig.DEFAULT_START,
				format);
	}

	@Override
	public DoubanResponse<DoubanNotes> getNotesUserCreated(String userName,
			int count, int start, String format) throws DoubanException,
			IOException {
		String path = getApiPath(DoubanConfig.Path.NOTES_CREATED, userName);
		return getNotes(path, format, count, start);
	}

	/**
	 * 
	 * 用户喜欢的日记
	 * 
	 */

	@Override
	public DoubanResponse<DoubanNotes> getNotesUserLiked(String userName)
			throws DoubanException, IOException {
		return getNotesUserLiked(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.NOTE_FORMAT_TEXT);
	}

	@Override
	public DoubanResponse<DoubanNotes> getNotesUserLiked(String userName,
			int count, String format) throws DoubanException, IOException {
		return getNotesUserLiked(userName, count, DoubanConfig.DEFAULT_START,
				format);
	}

	@Override
	public DoubanResponse<DoubanNotes> getNotesUserLiked(String userName,
			int count, int start, String format) throws DoubanException,
			IOException {
		String path = getApiPath(DoubanConfig.Path.NOTES_LIKED, userName);
		return getNotes(path, format, count, start);
	}

	/**
	 * 
	 * 推荐给用户的日记（API路径有问题）
	 */

	@Override
	public DoubanResponse<DoubanNotes> getNotesGuesses(String userName)
			throws DoubanException, IOException {
		return getNotesGuesses(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.NOTE_FORMAT_TEXT);
	}

	@Override
	public DoubanResponse<DoubanNotes> getNotesGuesses(String userName,
			int count, String format) throws DoubanException, IOException {
		return getNotesGuesses(userName, count, DoubanConfig.DEFAULT_START,
				format);
	}

	@Override
	public DoubanResponse<DoubanNotes> getNotesGuesses(String userName,
			int count, int start, String format) throws DoubanException,
			IOException {
		String path = getApiPath(DoubanConfig.Path.NOTES_HOT, userName);
		return getNotes(path, format, count, start);
	}

	/**
	 * 
	 * 单篇日记
	 */

	@Override
	public DoubanResponse<DoubanNote> getNote(long noteId)
			throws DoubanException, IOException {
		return getNote(noteId, DoubanConfig.NOTE_FORMAT_TEXT);
	}

	@Override
	public DoubanResponse<DoubanNote> getNote(long noteId, String format)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.NOTE_ID, noteId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.FORMAT,
				StringUtils.isEmpty(format) ? DoubanConfig.NOTE_FORMAT_TEXT
						: format);
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanNote.class);
	}

	/**
	 * 
	 * 删除日记
	 */
	@Override
	public DoubanResponse<DoubanNote> delete(long noteId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.NOTE_ID, noteId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanNote.class);
	}

	/**
	 * 喜欢日记
	 */

	@Override
	public DoubanResponse<DoubanNote> likeNote(long noteId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.NOTE_LIKE, noteId);
		SimpleResponse response = doPost(path);
		return parse(response, DoubanNote.class);
	}

	/**
	 * 
	 * 取消喜欢日记
	 */

	@Override
	public DoubanResponse<DoubanNote> unlikeNote(long noteId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.NOTE_LIKE, noteId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanNote.class);
	}

	/**
	 * 
	 * 发布日记
	 */

	@Override
	public DoubanResponse<DoubanNote> writeNote(String title, String content)
			throws DoubanException, IOException {
		return writeNote(title, content, true);
	}

	@Override
	public DoubanResponse<DoubanNote> writeNote(String title, String content,
			boolean canReply) throws DoubanException, IOException {
		return writeNote(title, content, canReply, DoubanConfig.PRIVACY_PUBLIC);
	}

	@Override
	public DoubanResponse<DoubanNote> writeNote(String title, String content,
			boolean canReply, String privacy) throws DoubanException,
			IOException {
		AssertUtils.notEmpty(title, "note titlle must not be null.");
		AssertUtils.notEmpty(content, " note content must not be null");
		String path = getApiPath(DoubanConfig.Path.NOTES);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.TITLE, title);
		params.put(DoubanConfig.Key.CONTENT, content);
		params.put(DoubanConfig.Key.CAN_REPLY, String.valueOf(canReply));
		params.put(DoubanConfig.Key.PRIVACY,
				StringUtils.isEmpty(privacy) ? DoubanConfig.PRIVACY_PUBLIC
						: privacy);
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanNote.class);
	}

	/**
	 * 更新日记
	 */

	@Override
	public DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content) throws DoubanException, IOException {
		return updateNote(noteId, title, content, true);
	}

	@Override
	public DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content, boolean canReply) throws DoubanException,
			IOException {
		return updateNote(noteId, title, content, canReply,
				DoubanConfig.PRIVACY_PUBLIC);
	}

	@Override
	public DoubanResponse<DoubanNote> updateNote(long noteId, String title,
			String content, boolean canReply, String privacy)
			throws DoubanException, IOException {
		AssertUtils.isTrue(noteId > 0, "note id must be valid.");
		AssertUtils.notEmpty(title, "note titlle must not be null.");
		AssertUtils.notEmpty(content, " note content must not be null");
		String path = getApiPath(DoubanConfig.Path.NOTE_ID, noteId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.TITLE, title);
		params.put(DoubanConfig.Key.CONTENT, content);
		params.put(DoubanConfig.Key.CAN_REPLY, String.valueOf(canReply));
		params.put(DoubanConfig.Key.PRIVACY,
				StringUtils.isEmpty(privacy) ? DoubanConfig.PRIVACY_PUBLIC
						: privacy);
		SimpleResponse response = doPut(path, params);
		return parse(response, DoubanNote.class);
	}

	/**
	 * 日记评论
	 */

	@Override
	public DoubanResponse<DoubanComments> getNoteComments(long noteId)
			throws DoubanException, IOException {
		return getNoteComments(noteId, DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<DoubanComments> getNoteComments(long noteId, int count)
			throws DoubanException, IOException {
		return getNoteComments(noteId, count, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<DoubanComments> getNoteComments(long noteId,
			int count, int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.NOTE_COMMENTS, noteId);
		Map<String, String> params = new HashMap<String, String>();
		if (count > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		}
		if (start > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.START, String.valueOf(start));
		}
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanComments.class);
	}

	@Override
	public DoubanResponse<DoubanComment> addNoteComment(long noteId, String text)
			throws DoubanException, IOException {
		AssertUtils.notEmpty(text, "comment text must not be null or empty");
		String path = getApiPath(DoubanConfig.Path.NOTE_COMMENTS, noteId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.CONTENT, text);
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanComment.class);
	}

	@Override
	public DoubanResponse<DoubanComment> getNoteComment(long noteId,
			long commentId) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.NOTE_COMMENT, noteId,
				commentId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanComment.class);
	}

	@Override
	public DoubanResponse<DoubanComment> deleteNoteComment(long noteId,
			long commentId) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.NOTE_COMMENT, noteId,
				commentId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanComment.class);
	}

	/**
	 * 
	 * 相册，照片
	 * 
	 */

	@Override
	public DoubanResponse<DoubanAlbums> getAlbumsUserCreated(String userName)
			throws DoubanException, IOException {
		return getAlbumsUserCreated(userName, DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<DoubanAlbums> getAlbumsUserCreated(String userName,
			int count) throws DoubanException, IOException {
		return getAlbumsUserCreated(userName, count, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<DoubanAlbums> getAlbumsUserCreated(String userName,
			int count, int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.ALBUMS_CREATED, userName);
		Map<String, String> params = new HashMap<String, String>();
		if (count > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		}
		if (start > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.START, String.valueOf(start));
		}
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanAlbums.class);
	}

	@Override
	public DoubanResponse<DoubanAlbums> getAlbumsUserLiked(String userName)
			throws DoubanException, IOException {
		return getAlbumsUserLiked(userName, DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<DoubanAlbums> getAlbumsUserLiked(String userName,
			int count) throws DoubanException, IOException {
		return getAlbumsUserLiked(userName, count, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<DoubanAlbums> getAlbumsUserLiked(String userName,
			int count, int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.ALBUMS_LIKED, userName);
		Map<String, String> params = new HashMap<String, String>();
		if (count > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		}
		if (start > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.START, String.valueOf(start));
		}
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanAlbums.class);
	}

	@Override
	public DoubanResponse<DoubanAlbum> createAlbum(String title, String privacy)
			throws DoubanException, IOException {
		AssertUtils.notEmpty(title, " album title must not be null or empty.");
		AssertUtils.notEmpty(privacy,
				" album privacy must not be null or empty.");
		String path = getApiPath(DoubanConfig.Path.ALBUMS);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.TITLE, title);
		params.put(DoubanConfig.Key.PRIVACY, privacy);
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanAlbum.class);
	}

	@Override
	public DoubanResponse<DoubanAlbum> getAlbum(long albumId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.ALBUM, albumId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanAlbum.class);
	}

	@Override
	public DoubanResponse<DoubanPhoto> uploadPhoto(long albumId, String desc,
			File image) throws DoubanException, IOException {
		AssertUtils.notNull(image, "upload file must not be null.");
		String path = getApiPath(DoubanConfig.Path.ALBUM, albumId);
		Map<String, String> params = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(desc)) {
			params.put(DoubanConfig.Key.DESC, desc);
		}
		SimpleResponse response = doPost(path, params, DoubanConfig.Key.IMAGE,
				image);
		return parse(response, DoubanPhoto.class);
	}

	@Override
	public DoubanResponse<DoubanAlbumPhotos> getAlbumPhotos(long albumId)
			throws DoubanException, IOException {
		return getAlbumPhotos(albumId, DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<DoubanAlbumPhotos> getAlbumPhotos(long albumId,
			int count) throws DoubanException, IOException {
		return getAlbumPhotos(albumId, count, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<DoubanAlbumPhotos> getAlbumPhotos(long albumId,
			int count, int start) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.PHTOTS, albumId);
		Map<String, String> params = new HashMap<String, String>();
		if (count > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		}
		if (start > DoubanConfig.INVALID_ID) {
			params.put(DoubanConfig.Key.START, String.valueOf(start));
		}
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanAlbumPhotos.class);
	}

	@Override
	public DoubanResponse<DoubanPhoto> getPhoto(long photoId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.PHOTO, photoId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanPhoto.class);
	}

	/**
	 * 照片评论
	 */

	@Override
	public DoubanResponse<DoubanComments> getPhotoComments(long photoId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.PHOTO_COMMENTS, photoId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanComments.class);
	}

	@Override
	public DoubanResponse<DoubanComment> getPhotoComment(long photoId,
			long commentId) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.PHOTO_COMMENT, photoId,
				commentId);
		SimpleResponse response = doGet(path);
		return parse(response, DoubanComment.class);
	}

	@Override
	public DoubanResponse<DoubanComment> deletePhotoComment(long photoId,
			long commentId) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.PHOTO_COMMENT, photoId,
				commentId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanComment.class);
	}

	@Override
	public DoubanResponse<DoubanComment> addPhotoComment(long photoId,
			String text) throws DoubanException, IOException {
		AssertUtils.notEmpty(text,
				"photo comment text must not be null or empty. ");
		String path = getApiPath(DoubanConfig.Path.PHOTO_COMMENTS, photoId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.CONTENT, text);
		SimpleResponse response = doPost(path, params);
		return parse(response, DoubanComment.class);
	}

}
