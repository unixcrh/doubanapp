/**
 * 
 */
package org.mcxiaoke.douban;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mcxiaoke.commons.auth.Authorization;
import org.mcxiaoke.commons.auth.SignatureStyle;
import org.mcxiaoke.commons.http.HttpMethod;
import org.mcxiaoke.commons.http.RequestBuilder;
import org.mcxiaoke.commons.http.SimpleClient;
import org.mcxiaoke.commons.http.SimpleRequest;
import org.mcxiaoke.commons.http.SimpleResponse;
import org.mcxiaoke.commons.util.AssertUtils;
import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanShuo;
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
		if (path.startsWith(SCHEME_HTTPS)) {
			return path;
		} else {
			return API_HOST.concat(path);
		}
	}

	private RequestBuilder createRequestBuilder(HttpMethod method, String path,
			Map<String, String> params) {
		RequestBuilder builder = RequestBuilder.create();
		builder.setUrl(checkUrl(path));
		builder.setMethod(method);
		if (params != null && params.size() > 0) {
			builder.addParameters(params);
		}
		final Authorization authorization = getAuthorizationFromSession();
		if (authorization != null) {
			builder.setAuthorization(authorization);
		}
		return builder;
	}

	private SimpleResponse executeBodyRequest(HttpMethod method, String path,
			Map<String, String> params, String name, InputStream stream)
			throws DoubanException, IOException {
		AssertUtils.isTrue(HttpMethod.POST == method
				|| HttpMethod.PUT == method,
				" request with body must use post or put");
		AssertUtils.notEmpty(path,
				"request api path must not be null or empty.");
		AssertUtils.notEmpty(name,
				"file parameter name must not be null or empty.");
		AssertUtils.notNull(stream, "inputstream must not be null.");
		final SimpleRequest request = createRequestBuilder(method, path, params)
				.build();
		request.addFileParameter(name, stream);
		debug("executeBodyRequest: " + request);
		return mClient.execute(request);
	}

	private SimpleResponse executeNormalRequest(HttpMethod method, String path,
			Map<String, String> params) throws DoubanException, IOException {
		AssertUtils.notNull(method, "http method must not be null.");
		AssertUtils.notEmpty(path, "request api path must not be null. ");
		final SimpleRequest request = createRequestBuilder(method, path, params)
				.build();
		debug("executeNormalRequest: " + request);
		return mClient.execute(request);
	}

	private SimpleResponse doPost(String path, Map<String, String> params,
			String name, InputStream stream) throws DoubanException,
			IOException {
		return executeBodyRequest(HttpMethod.POST, path, params, name, stream);
	}

	private SimpleResponse doPost(String path, Map<String, String> params,
			String name, File file) throws FileNotFoundException,
			DoubanException, IOException {
		AssertUtils.notNull(file, " file parameter must not be null.");
		return doPost(path, params, name, new FileInputStream(file));
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
	public DoubanResponse<DoubanShuo> updateStatus(DoubanShuoUpdate status)
			throws DoubanException, IOException {
		AssertUtils.notNull(status,
				"shuo status update object must not be null.");
		String path = getApiPath(DoubanConfig.Path.STATUSES);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.TEXT, status.getText());
		params.put(DoubanConfig.Key.REC_TITLE, status.getRecTitle());
		params.put(DoubanConfig.Key.REC_URL, status.getRecUrl());
		params.put(DoubanConfig.Key.REC_DESC, status.getRecDesc());
		params.put(DoubanConfig.Key.REC_IMAGE, status.getRecImageUrl());
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		SimpleResponse response;
		if (status.hasImage()) {
			response = doPost(path, params, DoubanConfig.Key.IMAGE,
					status.getImage());
		} else {
			response = doPost(path, params);
		}
		return parse(response, DoubanShuo.class);
	}

	@Override
	public DoubanResponse<DoubanShuo> updateStatus(String text)
			throws DoubanException, IOException {
		return updateStatus(new DoubanShuoUpdate(text));
	}

	@Override
	public DoubanResponse<DoubanShuo> updateStatus(String text, File image)
			throws DoubanException, IOException {
		return updateStatus(new DoubanShuoUpdate(text, image));
	}

	@Override
	public DoubanResponse<DoubanShuo> updateStatus(String text,
			InputStream stream) throws DoubanException, IOException {
		AssertUtils.notEmpty(text, "status text must not be null or empty.");
		AssertUtils.notNull(stream,
				" status image input stream must not be null.");
		String path = getApiPath(DoubanConfig.Path.STATUSES);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.TEXT, text);
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		SimpleResponse response;
		if (stream != null) {
			response = doPost(path, params, DoubanConfig.Key.IMAGE, stream);
		} else {
			response = doPost(path, params);
		}
		return parse(response, DoubanShuo.class);
	}

	@Override
	public DoubanResponse<DoubanShuo> updateStatus(String text, String title,
			String url, String desc) throws DoubanException, IOException {
		return updateStatus(text, title, url, desc, null);
	}

	@Override
	public DoubanResponse<DoubanShuo> updateStatus(String text, String title,
			String url, String desc, String imageUrl) throws DoubanException,
			IOException {
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
	public DoubanResponse<DoubanShuo> showStatus(long statusId)
			throws DoubanException, IOException {
		return showStatus(statusId, false);
	}

	@Override
	public DoubanResponse<DoubanShuo> showStatus(long statusId, boolean simple)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS, statusId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.PACK, String.valueOf(simple));
		SimpleResponse response = doGet(path, params);
		return parse(response, DoubanShuo.class);
	}

	/**
	 * 删除一条消息
	 */
	@Override
	public DoubanResponse<DoubanShuo> deleteStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS, statusId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanShuo.class);
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
	public DoubanResponse<DoubanShuo> reshareStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_RESHARE, statusId);
		SimpleResponse response = doPost(path);
		return parse(response, DoubanShuo.class);
	}

	@Override
	public DoubanResponse<DoubanShuo> unreshareStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS, statusId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanShuo.class);
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
	public DoubanResponse<DoubanShuo> likeStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_LIKE, statusId);
		SimpleResponse response = doPost(path);
		return parse(response, DoubanShuo.class);
	}

	@Override
	public DoubanResponse<DoubanShuo> unlikeStatus(long statusId)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_LIKE, statusId);
		SimpleResponse response = doDelete(path);
		return parse(response, DoubanShuo.class);
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
		SimpleResponse response = doGet(path);
		return parse(response, new TypeReference<List<DoubanComment>>() {
		});
	}

	@Override
	public DoubanResponse<DoubanComment> addStatusComment(long statusId,
			String text) throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUS_COMMENTS, statusId);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.TEXT, text);
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

	private DoubanResponse<List<DoubanShuo>> getTimeline(String path,
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
		return parse(response, new TypeReference<List<DoubanShuo>>() {
		});
	}

	/**
	 * Home时间线
	 */
	@Override
	public DoubanResponse<List<DoubanShuo>> getHomeTimeline()
			throws DoubanException, IOException {
		return getHomeTimeline(DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getHomeTimeline(long sinceId)
			throws DoubanException, IOException {
		return getHomeTimeline(sinceId, DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getHomeTimeline(long sinceId,
			long maxId) throws DoubanException, IOException {
		return getHomeTimeline(sinceId, maxId, DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getHomeTimeline(long sinceId,
			long maxId, int count) throws DoubanException, IOException {
		return getHomeTimeline(sinceId, maxId, count,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getHomeTimeline(long sinceId,
			long maxId, int count, int start) throws DoubanException,
			IOException {
		String path = getApiPath(DoubanConfig.Path.STATUSES_HOME);
		return getTimeline(path, sinceId, maxId, count, start);
	}

	/**
	 * 用户时间线
	 */
	@Override
	public DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName)
			throws DoubanException, IOException {
		return getUserTimeline(userName, DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId) throws DoubanException, IOException {
		return getUserTimeline(userName, sinceId, DoubanConfig.INVALID_ID);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId, long maxId) throws DoubanException, IOException {
		return getUserTimeline(userName, sinceId, maxId,
				DoubanConfig.DEFAULT_COUNT);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId, long maxId, int count) throws DoubanException,
			IOException {
		return getUserTimeline(userName, sinceId, maxId, count,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanShuo>> getUserTimeline(String userName,
			long sinceId, long maxId, int count, int start)
			throws DoubanException, IOException {
		String path = getApiPath(DoubanConfig.Path.STATUSES_USER, userName);
		return getTimeline(path, sinceId, maxId, count, start);
	}

	/***
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
