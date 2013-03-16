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
public class DoubanBookCollection extends AbstractListModel {
	@JsonProperty("collections")
	private List<DoubanBookItem> collections;

	public List<DoubanBookItem> getCollections() {
		return collections;
	}

	public void setCollections(List<DoubanBookItem> collections) {
		this.collections = collections;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanBooksCollection [collections=");
		builder.append(collections);
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