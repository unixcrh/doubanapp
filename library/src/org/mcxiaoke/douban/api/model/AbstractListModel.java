/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * @param <T>
 * 
 */
public abstract class AbstractListModel<T> extends AbstractModel {
	public static final int NULL_SIZE = -1;
	public static final int EMPTY_SIZE = 0;
	
	@JsonProperty("count")
	private int count;
	@JsonProperty("start")
	private int start;
	@JsonProperty("total")
	private int total;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public abstract List<T> getData();

	public abstract int size();
}
