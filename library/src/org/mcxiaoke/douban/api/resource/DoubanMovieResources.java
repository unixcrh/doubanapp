/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.api.model.DoubanMovie;

/**
 * @author mcxiaoke
 *
 */
public interface DoubanMovieResources {
	
	DoubanMovie getMovie(long movieId);

}
