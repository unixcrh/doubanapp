/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanRelationItem extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("screen_name")
	private String screenName;
	@JsonProperty("following")
	private boolean following;
	@JsonProperty("followed_by")
	private boolean followedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public boolean isFollowing() {
		return following;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}

	public boolean isFollowedBy() {
		return followedBy;
	}

	public void setFollowedBy(boolean followedBy) {
		this.followedBy = followedBy;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanRelationItem [id=");
		builder.append(id);
		builder.append(", screenName=");
		builder.append(screenName);
		builder.append(", following=");
		builder.append(following);
		builder.append(", followedBy=");
		builder.append(followedBy);
		builder.append("]");
		return builder.toString();
	}

}
