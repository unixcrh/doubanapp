/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.api.model.DoubanEvent;
import org.mcxiaoke.douban.api.model.DoubanEvents;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanEventsResources {
	DoubanEvent getEvent(long eventId);

	DoubanUsers getEventParticipants(long eventId);

	DoubanEvents getEventsByCity(int locId);

	DoubanEvents getEventsUserParticipanted(long userId);

	DoubanEvents getEventsUserParticipanted(String userName);

	DoubanEvents getEventsUserWishes(long userId);

	DoubanEvents getEventsUserWishes(String userName);

	DoubanEvents getEventsUserCreated(long userId);

	DoubanEvents getEventsUserCreated(String userName);
}
