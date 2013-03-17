/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanOnlines extends AbstractListModel {
	@JsonProperty("onlines")
	private List<DoubanOnline> onlines;
	@JsonProperty("user")
	private DoubanUser user;

	public List<DoubanOnline> getOnlines() {
		return onlines;
	}

	public void setOnlines(List<DoubanOnline> onlines) {
		this.onlines = onlines;
	}

	public DoubanUser getUser() {
		return user;
	}

	public void setUser(DoubanUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanOnlines [onlines=");
		builder.append(onlines);
		builder.append(", user=");
		builder.append(user);
		builder.append(", getCount()=");
		builder.append(getCount());
		builder.append(", getStart()=");
		builder.append(getStart());
		builder.append(", getTotal()=");
		builder.append(getTotal());
		builder.append("]");
		return builder.toString();
	}

}
