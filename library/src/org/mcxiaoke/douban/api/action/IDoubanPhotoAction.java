/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import org.mcxiaoke.douban.api.model.DoubanAlbum;
import org.mcxiaoke.douban.api.model.DoubanAlbumPhotos;
import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanComments;
import org.mcxiaoke.douban.api.model.DoubanPhoto;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanPhotoAction {

	// GET https://api.douban.com/v2/album/:id
	DoubanAlbum getAlbum(long albumId);

	// GET https://api.douban.com/v2/album/:id/photos
	DoubanAlbumPhotos getAlbumPhotos(long albumId);

	// GET https://api.douban.com/v2/photo/:id
	DoubanPhoto getPhoto(long photoId);

	// GET /v2/photo/:id/comments
	DoubanComments getPhotoComments(long photoId);

	// GET /v2/photo/:id/comment/:id
	DoubanComment getPhotoComment(long photoId, long commentId);

}
