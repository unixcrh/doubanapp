/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanShuoEntityUser extends DoubanShuoEntityItemBase {
	@JsonProperty("id")
	private long id;
	@JsonProperty("uid")
	private String uid;
	@JsonProperty("screen_name")
	private String screenName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanShuoEntityUsers [indices=");
		builder.append(Arrays.toString(getIndices()));
		builder.append(", id=");
		builder.append(id);
		builder.append(", uid=");
		builder.append(uid);
		builder.append(", screenName=");
		builder.append(screenName);
		builder.append("]");
		return builder.toString();
	}

}
