/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanComments extends AbstractListModel<DoubanComment> {
	@JsonProperty("comments")
	private List<DoubanComment> comments;

	public List<DoubanComment> getComments() {
		return comments;
	}

	public void setComments(List<DoubanComment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanComments [comments=");
		builder.append(comments);
		builder.append(", getCount()=");
		builder.append(getCount());
		builder.append(", getStart()=");
		builder.append(getStart());
		builder.append(", getTotal()=");
		builder.append(getTotal());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<DoubanComment> getData() {
		return comments;
	}

	@Override
	public int size() {
		return comments == null ? NULL_SIZE : comments.size();
	}

}
