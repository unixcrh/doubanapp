/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanNotes extends AbstractModel {
	private int count;
	private int start;
	private int total;
	private DoubanUser user;
	private List<DoubanNote> notes;

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

}
