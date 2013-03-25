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
public class DoubanBookCollections extends
		AbstractListModel<DoubanBookCollectionItem> {
	@JsonProperty("collections")
	private List<DoubanBookCollectionItem> collections;

	public DoubanBookCollections() {
		this(null);
	}

	public DoubanBookCollections(List<DoubanBookCollectionItem> data) {
		this.collections = new ArrayList<DoubanBookCollectionItem>();
		if (data != null) {
			this.collections.addAll(data);
		}
	}

	public List<DoubanBookCollectionItem> getCollections() {
		return collections;
	}

	public void setCollections(List<DoubanBookCollectionItem> collections) {
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

	@Override
	public List<DoubanBookCollectionItem> getData() {
		return collections;
	}

	@Override
	public int size() {
		return collections == null ? NULL_SIZE : collections.size();
	}

}
