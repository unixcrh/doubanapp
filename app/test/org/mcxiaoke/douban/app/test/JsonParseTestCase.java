package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.mcxiaoke.douban.api.model.DoubanAlbum;
import org.mcxiaoke.douban.api.model.DoubanAlbumPhotos;
import org.mcxiaoke.douban.api.model.DoubanPhoto;
import org.mcxiaoke.douban.api.model.DoubanShuo;
import org.mcxiaoke.douban.api.model.DoubanUser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseTestCase extends BaseTestCase {

	public void atestUser() throws IOException {
		InputStream is = openAssets("json/user.json");
		ObjectMapper om = new ObjectMapper();
		DoubanUser u = om.readValue(is, DoubanUser.class);
		assertNotNull(u);
		debug(u);
	}

	public void atestAlbum() throws IOException {
		InputStream is = openAssets("json/album.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanAlbum a = om.readValue(is, DoubanAlbum.class);
		assertNotNull(a);
		debug(a);
	}

	public void atestPhoto() throws IOException {
		InputStream is = openAssets("json/photo.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanPhoto a = om.readValue(is, DoubanPhoto.class);
		assertNotNull(a);
		debug(a);
	}

	public void atestAlbumPhotos() throws IOException {
		InputStream is = openAssets("json/photos.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanAlbumPhotos a = om.readValue(is, DoubanAlbumPhotos.class);
		assertNotNull(a);
		debug(a);
	}

	public void testShuo() throws IOException {
		InputStream is = openAssets("json/shuo.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		List<DoubanShuo> a = om.readValue(is,
				new TypeReference<List<DoubanShuo>>() {
				});
		assertNotNull(a);
		for (DoubanShuo ds : a) {
			debug(ds);
		}
	}

}
