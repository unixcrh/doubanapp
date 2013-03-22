/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.api.model.DoubanMusic;
import org.mcxiaoke.douban.api.model.DoubanMusics;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMusicResources {

	DoubanMusic getMusic(long musicId);

	DoubanMusics searchMusic(String query);

	DoubanMusics searchMusic(String query, String tag);

	DoubanMusics searchMusic(String query, String tag, int count);

	DoubanMusics searchMusic(String query, String tag, int count, int start);

}
