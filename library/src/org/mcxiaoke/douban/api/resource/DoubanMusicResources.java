/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanMusic;
import org.mcxiaoke.douban.api.model.DoubanMusics;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMusicResources {

	DoubanResponse<DoubanMusic> getMusic(long musicId);

	DoubanResponse<DoubanMusics> searchMusic(String query);

	DoubanResponse<DoubanMusics> searchMusic(String query, String tag);

	DoubanResponse<DoubanMusics> searchMusic(String query, String tag, int count);

	DoubanResponse<DoubanMusics> searchMusic(String query, String tag,
			int count, int start);

}
