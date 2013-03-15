/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanEvents extends AbstractModel {
	private int count;
	private int start;
	private int total;
	private List<DoubanEvent> events;

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

	public List<DoubanEvent> getEvents() {
		return events;
	}

	public void setEvents(List<DoubanEvent> events) {
		this.events = events;
	}

}
