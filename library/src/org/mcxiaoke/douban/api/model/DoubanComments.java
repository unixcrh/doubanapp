/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanComments extends AbstractModel {
	private int count;
	private int start;
	private int total;
	private List<DoubanComment> comments;

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

	public List<DoubanComment> getComments() {
		return comments;
	}

	public void setComments(List<DoubanComment> comments) {
		this.comments = comments;
	}

}
