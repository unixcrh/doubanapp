/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanEvent;
import org.mcxiaoke.douban.api.model.DoubanEvents;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanEventsResources {
	DoubanResponse<DoubanEvent> getEvent(long eventId);

	DoubanResponse<DoubanUsers> getEventParticipants(long eventId);

	DoubanResponse<DoubanEvents> getEventsByCity(int locId);

	DoubanResponse<DoubanEvents> getEventsUserParticipanted(long userId);

	DoubanResponse<DoubanEvents> getEventsUserParticipanted(String userName);

	DoubanResponse<DoubanEvents> getEventsUserWishes(long userId);

	DoubanResponse<DoubanEvents> getEventsUserWishes(String userName);

	DoubanResponse<DoubanEvents> getEventsUserCreated(long userId);

	DoubanResponse<DoubanEvents> getEventsUserCreated(String userName);
}
