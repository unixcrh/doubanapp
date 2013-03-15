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
public class DoubanNotes extends AbstractListModel {
	@JsonProperty("user")
	private DoubanUser user;
	@JsonProperty("notes")
	private List<DoubanNote> notes;

	public DoubanUser getUser() {
		return user;
	}

	public void setUser(DoubanUser user) {
		this.user = user;
	}

	public List<DoubanNote> getNotes() {
		return notes;
	}

	public void setNotes(List<DoubanNote> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanNotes [user=");
		builder.append(user);
		builder.append(", notes=");
		builder.append(notes);
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
