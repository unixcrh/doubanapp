/**
 * 
 */
package org.mcxiaoke.douban.app.test;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.mcxiaoke.douban.DoubanErrorCode;
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
public class PhotosResourcesTestCase extends BaseApiTestCase {

	/**
	 * 获取相册
	 */

	public void IGNOREtestGetAlbumNormal() throws DoubanException, IOException {
		long id = 81671983;
		DoubanResponse<DoubanAlbum> res = api.getAlbum(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanAlbum album = res.getData();
		assertNotNull(album);
		assertEquals(id, album.getId());
	}

	public void IGNOREtestGetAlbumNotExists() throws DoubanException,
			IOException {
		long id = 9981671983L;
		DoubanResponse<DoubanAlbum> res = api.getAlbum(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		DoubanAlbum album = res.getData();
		assertNull(album);
	}

	/**
	 * 获取相册照片
	 */
	public void IGNOREtestGetAlbumPhotosNormal() throws DoubanException,
			IOException {
		long id = 81671983;
		DoubanResponse<DoubanAlbumPhotos> res = api.getAlbumPhotos(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanAlbumPhotos dp = res.getData();
		assertNotNull(dp);
		DoubanAlbum album = dp.getAlbum();
		assertEquals(id, album.getId());
	}

	public void IGNOREtestGetAlbumPhotosNotExists() throws DoubanException,
			IOException {
		long id = 9981671983L;
		DoubanResponse<DoubanAlbumPhotos> res = api.getAlbumPhotos(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		DoubanAlbumPhotos dp = res.getData();
		assertNull(dp);
	}

	/**
	 * 获取照片
	 */
	public void IGNOREtestGetPhotoNormal() throws DoubanException, IOException {
		long id = 1783640454;
		DoubanResponse<DoubanPhoto> res = api.getPhoto(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanPhoto album = res.getData();
		assertNotNull(album);
		assertEquals(id, album.getId());
	}

	public void IGNOREtestGetPhotoNotExists() throws DoubanException,
			IOException {
		long id = 9981671983L;
		DoubanResponse<DoubanPhoto> res = api.getPhoto(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		DoubanPhoto album = res.getData();
		assertNull(album);
	}

	/**
	 * 照片评论
	 */
	public void IGNOREtestGetPhotoCommentsNormal() throws DoubanException,
			IOException {
		long id = 1783640454;
		DoubanResponse<DoubanComments> res = api.getPhotoComments(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanComments dc = res.getData();
		assertNotNull(dc);
		assertTrue(dc.size() > 0);
	}

	public void IGNOREtestGetPhotoCommentsNotExists() throws DoubanException,
			IOException {
		long id = 9993640454L;
		DoubanResponse<DoubanComments> res = api.getPhotoComments(id);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_NOT_FOUND, res.getStatusCode());
		DoubanComments dc = res.getData();
		assertTrue(dc == null || dc.size() < 1);
	}
	
	/**
	 *  照片单条评论
	 * @throws IOException 
	 * @throws DoubanException 
	 */
	public void IGNOREtestAddPhotoComment() throws DoubanException, IOException{
		// TODO need advanced scope?
		long id = 1783640454;
		String text="a photo comment text for test only.";
		DoubanResponse<DoubanComment> res=api.addPhotoComment(id, text);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		DoubanComment dc=res.getData();
		assertNotNull(dc);
		assertEquals(text, dc.getContent());
	}
	
	public void IGNOREtestDeletePhotoComment() throws DoubanException, IOException{
		// TODO need advanced scope?
		long id=1783640454;
		long cid=0;
		DoubanResponse<DoubanComment> res=api.deletePhotoComment(1783640454, cid);
		assertNotNull(res);
		assertEquals(HttpStatus.SC_OK, res.getStatusCode());
		assertEquals(DoubanErrorCode.CODE_OK, res.getErrorCode());
		assertNull(res.getData());
	}

}
