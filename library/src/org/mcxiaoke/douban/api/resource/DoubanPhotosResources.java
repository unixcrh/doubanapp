/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.DoubanResponse;
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

	DoubanResponse<DoubanAlbum> getAlbum(long albumId);

	DoubanResponse<DoubanAlbumPhotos> getAlbumPhotos(long albumId);

	DoubanResponse<DoubanPhoto> getPhoto(long photoId);

	DoubanResponse<DoubanComments> getPhotoComments(long photoId);

	DoubanResponse<DoubanComment> getPhotoComment(long photoId, long commentId);

	DoubanResponse<DoubanComment> deletePhotoComment(long photoId,
			long commentId);

	DoubanResponse<DoubanComment> addPhotoComment(long id, String text);

}
