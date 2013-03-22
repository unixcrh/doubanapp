/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.api.model.DoubanOnline;
import org.mcxiaoke.douban.api.model.DoubanOnlines;
import org.mcxiaoke.douban.api.model.DoubanUsers;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanOnlineResources {

	DoubanOnline getOnlineEvent(long onlineEventId);

	DoubanUsers getOnlineEventParticipants(long onlineEventId);

	DoubanOnlines getOnlineEvents();

	DoubanOnlines getOnlineEvents(int count);

	DoubanOnlines getOnlineEvents(int count, int start);

}
