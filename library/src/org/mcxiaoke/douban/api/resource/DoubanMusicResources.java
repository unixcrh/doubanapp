/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanMusic;
import org.mcxiaoke.douban.api.model.DoubanMusics;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMusicResources {

	DoubanResponse<DoubanMusic> getMusic(long musicId) throws DoubanException, IOException;

	DoubanResponse<DoubanMusics> searchMusic(String query) throws DoubanException, IOException;

	DoubanResponse<DoubanMusics> searchMusic(String query, String tag) throws DoubanException, IOException;

	DoubanResponse<DoubanMusics> searchMusic(String query, String tag, int count) throws DoubanException, IOException;

	DoubanResponse<DoubanMusics> searchMusic(String query, String tag,
			int count, int start) throws DoubanException, IOException;

}
