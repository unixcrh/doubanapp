/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanMovie;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMovieResources {

	DoubanResponse<DoubanMovie> getMovie(long movieId);

}
