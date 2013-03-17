/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import org.mcxiaoke.douban.api.model.DoubanMusic;
import org.mcxiaoke.douban.api.model.DoubanMusics;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanMusicAction {

	// GET https://api.douban.com/v2/music/:id
	DoubanMusic getMusic(long musicId);

	// GET https://api.douban.com/v2/music/search
	DoubanMusics getMusicsSearch(String query, String tag, int start, int count);

	// POST https://api.douban.com/v2/music/reviews
	String writeMusicReview(long musicId, String title, String content, int rate);

	// PUT https://api.douban.com/v2/music/review/:id
	String updateMusicReview(long reviewId, String title, String content,
			int rate);

	// DELETE https://api.douban.com/v2/music/review/:id
	String deleteMusicReview(long reviewId);

}
