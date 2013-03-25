/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanOnline;
import org.mcxiaoke.douban.api.model.DoubanOnlines;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanOnlineResources {

	DoubanResponse<DoubanOnline> getOnlineEvent(long onlineEventId);

	DoubanResponse<DoubanUsers> getOnlineEventParticipants(long onlineEventId);

	DoubanResponse<DoubanOnlines> getOnlineEvents();

	DoubanResponse<DoubanOnlines> getOnlineEvents(int count);

	DoubanResponse<DoubanOnlines> getOnlineEvents(int count, int start);

}
