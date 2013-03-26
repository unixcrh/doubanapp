/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;

import org.mcxiaoke.douban.DoubanException;
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

	DoubanResponse<DoubanAlbum> getAlbum(long albumId) throws DoubanException,
			IOException;

	DoubanResponse<DoubanAlbumPhotos> getAlbumPhotos(long albumId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanPhoto> getPhoto(long photoId) throws DoubanException,
			IOException;

	DoubanResponse<DoubanComments> getPhotoComments(long photoId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanComment> getPhotoComment(long photoId, long commentId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanComment> deletePhotoComment(long photoId,
			long commentId) throws DoubanException, IOException;

	DoubanResponse<DoubanComment> addPhotoComment(long id, String text)
			throws DoubanException, IOException;

}
