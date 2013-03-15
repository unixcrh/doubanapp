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

}
