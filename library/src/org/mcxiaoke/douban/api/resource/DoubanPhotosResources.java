/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.api.model.DoubanAlbum;
import org.mcxiaoke.douban.api.model.DoubanAlbumPhotos;
import org.mcxiaoke.douban.api.model.DoubanComment;
import org.mcxiaoke.douban.api.model.DoubanComments;
import org.mcxiaoke.douban.api.model.DoubanPhoto;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanPhotosResources {

	DoubanAlbum getAlbum(long albumId);

	DoubanAlbumPhotos getAlbumPhotos(long albumId);

	DoubanPhoto getPhoto(long photoId);

	DoubanComments getPhotoComments(long photoId);

	DoubanComment getPhotoComment(long photoId, long commentId);

	DoubanComment deletePhotoComment(long photoId, long commentId);

	DoubanComment addPhotoComment(long id, String text);

}
