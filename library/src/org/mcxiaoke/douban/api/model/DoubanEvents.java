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
public class DoubanEvents extends AbstractListModel {
	@JsonProperty("events")
	private List<DoubanEvent> events;

	public List<DoubanEvent> getEvents() {
		return events;
	}

	public void setEvents(List<DoubanEvent> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanEvents [events=");
		builder.append(events);
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
