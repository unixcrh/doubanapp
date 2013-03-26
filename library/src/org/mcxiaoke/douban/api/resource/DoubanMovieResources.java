/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanMovie;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMovieResources {

	DoubanResponse<DoubanMovie> getMovie(long movieId) throws DoubanException, IOException;

}
