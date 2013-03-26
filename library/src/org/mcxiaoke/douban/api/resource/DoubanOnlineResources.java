/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanOnline;
import org.mcxiaoke.douban.api.model.DoubanOnlines;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanOnlineResources {

	DoubanResponse<DoubanOnline> getOnlineEvent(long onlineEventId) throws DoubanException, IOException;

	DoubanResponse<DoubanUsers> getOnlineEventParticipants(long onlineEventId) throws DoubanException, IOException;

	DoubanResponse<DoubanOnlines> getOnlineEvents() throws DoubanException, IOException;

	DoubanResponse<DoubanOnlines> getOnlineEvents(int count) throws DoubanException, IOException;

	DoubanResponse<DoubanOnlines> getOnlineEvents(int count, int start) throws DoubanException, IOException;

}
