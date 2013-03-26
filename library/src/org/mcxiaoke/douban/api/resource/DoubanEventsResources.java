/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanEvent;
import org.mcxiaoke.douban.api.model.DoubanEvents;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanEventsResources {
	DoubanResponse<DoubanEvent> getEvent(long eventId) throws DoubanException,
			IOException;

	DoubanResponse<DoubanUsers> getEventParticipants(long eventId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanEvents> getEventsByCity(int locId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanEvents> getEventsUserParticipanted(long userId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanEvents> getEventsUserParticipanted(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanEvents> getEventsUserWishes(long userId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanEvents> getEventsUserWishes(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanEvents> getEventsUserCreated(long userId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanEvents> getEventsUserCreated(String userName)
			throws DoubanException, IOException;
}
