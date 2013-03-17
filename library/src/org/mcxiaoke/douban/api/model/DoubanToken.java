/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanToken extends AbstractModel {
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("")
	private String refreshToken;
	@JsonProperty("expires_in")
	private long expiresAt;
	@JsonProperty("douban_user_id")
	private String userId;
	@JsonProperty("douban_user_name")
	private String userName;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public long getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(long expiresAt) {
		this.expiresAt = expiresAt + System.currentTimeMillis();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanToken [accessToken=");
		builder.append(accessToken);
		builder.append(", refreshToken=");
		builder.append(refreshToken);
		builder.append(", expiresAt=");
		builder.append(expiresAt);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}

}
