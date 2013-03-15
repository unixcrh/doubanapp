package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.io.InputStream;

import org.mcxiaoke.douban.api.model.DoubanAlbum;
import org.mcxiaoke.douban.api.model.DoubanAlbumPhotos;
import org.mcxiaoke.douban.api.model.DoubanPhoto;
import org.mcxiaoke.douban.api.model.DoubanUser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseTestCase extends BaseTestCase {

	public void testUser() throws IOException {
		InputStream is = openAssets("json/user.json");
		ObjectMapper om = new ObjectMapper();
		DoubanUser u = om.readValue(is, DoubanUser.class);
		debug(u);
		assertNotNull(u);
	}

	public void testAlbum() throws IOException {
		InputStream is = openAssets("json/album.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanAlbum a = om.readValue(is, DoubanAlbum.class);
		debug(a);
		assertNotNull(a);
	}

	public void testPhoto() throws IOException {
		InputStream is = openAssets("json/photo.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanPhoto a = om.readValue(is, DoubanPhoto.class);
		debug(a);
		assertNotNull(a);
	}

	public void testAlbumPhotos() throws IOException {
		InputStream is = openAssets("json/photos.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanAlbumPhotos a = om.readValue(is, DoubanAlbumPhotos.class);
		debug(a);
		assertNotNull(a);
	}

}
