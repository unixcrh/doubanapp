/**
 * 
 */
package org.mcxiaoke.douban;

import java.io.File;
import java.io.IOException;
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
import org.mcxiaoke.commons.util.StringUtils;
import org.mcxiaoke.douban.api.model.DoubanRelation;
import org.mcxiaoke.douban.api.model.DoubanUser;
import org.mcxiaoke.douban.api.model.DoubanUsers;
import org.scribe.model.OAuthToken;

import android.content.Context;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanApiClientImpl implements DoubanApiClient {
	private static final String SCHEME_HTTP = "http://";
	private static final String SCHEME_HTTPS = "https://";
	private static final String API_HOST = DoubanConfig.API_HOST;
	private Context mContext;
	private SimpleClient mClient;
	private DoubanSession mSession;

	// private oauthc

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

	@SuppressWarnings("unused")
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

	private SimpleResponse sendRequest(String path, HttpMethod method,
			Map<String, String> parameters, Map<String, String> headers,
			String key, File file) throws IOException {
		String url = checkUrl(path);
		RequestBuilder builder = RequestBuilder.create();
		builder.setUrl(url).setMethod(method).addHeaders(headers)
				.addParameters(parameters);
		if (HttpMethod.POST == method || HttpMethod.PUT == method) {
			if (StringUtils.isNotEmpty(key) && file != null) {
				builder.addParameter(key, file);
			}
		}
		if (HttpMethod.POST == method) {
			builder.addQueryParameter(DoubanConfig.Key.APPKEY,
					mSession.getApiKey());
		}
		if (mSession.isSessionValid()) {
			String accessToken = mSession.getToken();
			final Authorization auth = new Authorization(accessToken);
			auth.setSignatureStyle(SignatureStyle.HEADER_BEARER);
			builder.setAuthorization(auth);
		}
		SimpleRequest simpleRequest = builder.build();
		return mClient.execute(simpleRequest);
	}

	public <T> DoubanResponse<T> execute(String path, HttpMethod method,
			Map<String, String> parameters, final TypeReference<T> type) {
		return execute(path, method, parameters, null, null, null, type);
	}

	public <T> DoubanResponse<T> execute(String path, HttpMethod method,
			Map<String, String> parameters, Map<String, String> headers,
			final TypeReference<T> type) {
		return execute(path, method, parameters, headers, null, null, type);
	}

	public <T> DoubanResponse<T> execute(String path, HttpMethod method,
			Map<String, String> parameters, Map<String, String> headers,
			String key, File file, final TypeReference<T> type) {
		DoubanResponse<T> result = null;
		try {
			SimpleResponse response = sendRequest(path, method, parameters,
					headers, key, file);
			result = new DoubanResponse<T>(response, type);
		} catch (IOException e) {
			e.printStackTrace();
			result = new DoubanResponse<T>(DoubanErrorCode.CODE_NETWORK_ERROR);
		}
		return result;
	}

	private <T> DoubanResponse<T> doGet(String path, TypeReference<T> type) {
		return execute(path, HttpMethod.GET, null, type);
	}

	private <T> DoubanResponse<T> doGet(String path,
			Map<String, String> parameters, TypeReference<T> type) {
		return execute(path, HttpMethod.GET, parameters, type);
	}

	private <T> DoubanResponse<T> doDelete(String path, TypeReference<T> type) {
		return execute(path, HttpMethod.DELETE, null, type);
	}

	private <T> DoubanResponse<T> doDelete(String path,
			Map<String, String> parameters, TypeReference<T> type) {
		return execute(path, HttpMethod.DELETE, parameters, type);
	}

	private <T> DoubanResponse<T> doPost(String path, TypeReference<T> type) {
		return execute(path, HttpMethod.POST, null, type);
	}

	private <T> DoubanResponse<T> doPost(String path,
			Map<String, String> parameters, TypeReference<T> type) {
		return execute(path, HttpMethod.POST, parameters, type);
	}

	private <T> DoubanResponse<T> doPut(String path, TypeReference<T> type) {
		return execute(path, HttpMethod.PUT, null, type);
	}

	private <T> DoubanResponse<T> doPut(String path,
			Map<String, String> parameters, TypeReference<T> type) {
		return execute(path, HttpMethod.PUT, parameters, type);
	}

	public <T> DoubanResponse<T> execute(String path, HttpMethod method,
			Map<String, String> parameters, final Class<T> clazz) {
		return execute(path, method, parameters, null, null, null, clazz);
	}

	public <T> DoubanResponse<T> execute(String path, HttpMethod method,
			Map<String, String> parameters, Map<String, String> headers,
			final Class<T> clazz) {
		return execute(path, method, parameters, headers, null, null, clazz);
	}

	public <T> DoubanResponse<T> execute(String path, HttpMethod method,
			Map<String, String> parameters, Map<String, String> headers,
			String key, File file, final Class<T> clazz) {
		DoubanResponse<T> result = null;
		try {
			SimpleResponse response = sendRequest(path, method, parameters,
					headers, key, file);
			result = new DoubanResponse<T>(response, clazz);
		} catch (IOException e) {
			e.printStackTrace();
			result = new DoubanResponse<T>(DoubanErrorCode.CODE_NETWORK_ERROR);
		}
		return result;
	}

	private <T> DoubanResponse<T> doGet(String path, Class<T> clazz) {
		return execute(path, HttpMethod.GET, null, clazz);
	}

	private <T> DoubanResponse<T> doGet(String path,
			Map<String, String> parameters, Class<T> clazz) {
		return execute(path, HttpMethod.GET, parameters, clazz);
	}

	private <T> DoubanResponse<T> doDelete(String path, Class<T> clazz) {
		return execute(path, HttpMethod.DELETE, null, clazz);
	}

	private <T> DoubanResponse<T> doDelete(String path,
			Map<String, String> parameters, Class<T> clazz) {
		return execute(path, HttpMethod.DELETE, parameters, clazz);
	}

	private <T> DoubanResponse<T> doPost(String path, Class<T> clazz) {
		return execute(path, HttpMethod.POST, null, clazz);
	}

	private <T> DoubanResponse<T> doPost(String path,
			Map<String, String> parameters, Class<T> clazz) {
		return execute(path, HttpMethod.POST, parameters, clazz);
	}

	private <T> DoubanResponse<T> doPut(String path, Class<T> clazz) {
		return execute(path, HttpMethod.PUT, null, clazz);
	}

	private <T> DoubanResponse<T> doPut(String path,
			Map<String, String> parameters, Class<T> clazz) {
		return execute(path, HttpMethod.PUT, parameters, clazz);
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
	public DoubanResponse<DoubanUser> getUserInfo(long userId) {
		return getUserInfo(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<DoubanUser> getUserInfo(String userName) {
		String path = getApiPath(DoubanConfig.Path.USER, userName);
		return doGet(path, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> getAuthorizedUserInfo() {
		String path = getApiPath(DoubanConfig.Path.USER_ME);
		return doGet(path, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> followUser(long userId) {
		return followUser(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<DoubanUser> followUser(String userName) {
		String path = getApiPath(DoubanConfig.Path.USER_FOLLOW);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.USER_ID, userName);
		return doPost(path, params, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> unfollowUser(long userId) {
		return unfollowUser(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<DoubanUser> unfollowUser(String userName) {
		String path = getApiPath(DoubanConfig.Path.USER_UNFOLLOW);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.USER_ID, userName);
		return doPost(path, params, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> blockUser(long userId) {
		return blockUser(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<DoubanUser> blockUser(String userName) {
		String path = getApiPath(DoubanConfig.Path.USER_BLOCK, userName);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.USER_ID, userName);
		return doPost(path, params, DoubanUser.class);
	}

	@Override
	public DoubanResponse<DoubanUser> unblockUser(long userId) {
		return unblockUser(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<DoubanUser> unblockUser(String userName) {
		throw new UnsupportedOperationException(
				"unblock operation is now unsupported.");
	}

	@Override
	public DoubanResponse<DoubanRelation> getUsersRelation(long sourceId,
			long targetId) {
		return getUsersRelation(String.valueOf(sourceId),
				String.valueOf(targetId));
	}

	@Override
	public DoubanResponse<DoubanRelation> getUsersRelation(String sourceName,
			String targetName) {
		String path = getApiPath(DoubanConfig.Path.USER_FRIENDSHIP);
		Map<String, String> params = new HashMap<String, String>();
		params.put(DoubanConfig.Key.SOURCE_ID, sourceName);
		params.put(DoubanConfig.Key.TARGET_ID, targetName);
		params.put(DoubanConfig.Key.SOURCE, mSession.getApiKey());
		return doGet(path, params, DoubanRelation.class);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> searchUser(String query) {
		return searchUser(query, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> searchUser(String query, int count,
			int start) {
		String path = getApiPath(DoubanConfig.Path.USERS_SEARCH);
		Map<String, String> params = new HashMap<String, String>(3);
		params.put(DoubanConfig.Key.QUERY, query);
		params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		params.put(DoubanConfig.Key.START, String.valueOf(start));
		return doGet(path, params, new TypeReference<List<DoubanUser>>() {
		});
	}

	private DoubanResponse<List<DoubanUser>> getRelatedUsers(String path,
			int count, int start) {
		Map<String, String> params = new HashMap<String, String>(3);
		params.put(DoubanConfig.Key.COUNT, String.valueOf(count));
		params.put(DoubanConfig.Key.START, String.valueOf(start));
		return doGet(path, params, new TypeReference<List<DoubanUser>>() {
		});
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingUsers(long userId) {
		return getFollowingUsers(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName) {
		return getFollowingUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingUsers(long userId,
			int count, int start) {
		return getFollowingUsers(String.valueOf(userId),
				DoubanConfig.DEFAULT_COUNT, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingUsers(String userName,
			int count, int start) {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOWING, userName);
		return getRelatedUsers(path, count, start);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowersUsers(long userId) {
		return getFollowersUsers(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName) {
		return getFollowersUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowersUsers(long userId,
			int count, int start) {
		return getFollowersUsers(String.valueOf(userId),
				DoubanConfig.DEFAULT_COUNT, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowersUsers(String userName,
			int count, int start) {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOWERS, userName);
		return getRelatedUsers(path, count, start);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(long userId) {
		return getFollowInCommonUsers(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(
			String userName) {
		return getFollowInCommonUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(long userId,
			int count, int start) {
		return getFollowInCommonUsers(String.valueOf(userId),
				DoubanConfig.DEFAULT_COUNT, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowInCommonUsers(
			String userName, int count, int start) {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOW_IN_COMMON,
				userName);
		return getRelatedUsers(path, count, start);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingOfUsers(long userId) {
		return getFollowingOfUsers(String.valueOf(userId));
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingOfUsers(String userName) {
		return getFollowingOfUsers(userName, DoubanConfig.DEFAULT_COUNT,
				DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingOfUsers(long userId,
			int count, int start) {
		return getFollowingOfUsers(String.valueOf(userId),
				DoubanConfig.DEFAULT_COUNT, DoubanConfig.DEFAULT_START);
	}

	@Override
	public DoubanResponse<List<DoubanUser>> getFollowingOfUsers(
			String userName, int count, int start) {
		String path = getApiPath(DoubanConfig.Path.USERS_FOLLOW_ALSO, userName);
		return getRelatedUsers(path, count, start);
	}

}
