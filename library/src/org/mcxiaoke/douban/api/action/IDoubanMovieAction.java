/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import org.mcxiaoke.douban.api.model.DoubanMovie;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanMovieAction {

	// GET /v2/movie/subject/:id
	DoubanMovie getMovie(long movieId);
	
	// GET /v2/movie/celebrity/:id

}
