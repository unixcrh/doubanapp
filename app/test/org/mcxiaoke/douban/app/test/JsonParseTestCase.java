package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.mcxiaoke.douban.api.model.DoubanAlbum;
import org.mcxiaoke.douban.api.model.DoubanAlbumPhotos;
import org.mcxiaoke.douban.api.model.DoubanBook;
import org.mcxiaoke.douban.api.model.DoubanBookCollections;
import org.mcxiaoke.douban.api.model.DoubanComments;
import org.mcxiaoke.douban.api.model.DoubanEvents;
import org.mcxiaoke.douban.api.model.DoubanMails;
import org.mcxiaoke.douban.api.model.DoubanMovie;
import org.mcxiaoke.douban.api.model.DoubanNote;
import org.mcxiaoke.douban.api.model.DoubanNotes;
import org.mcxiaoke.douban.api.model.DoubanOnlines;
import org.mcxiaoke.douban.api.model.DoubanPhoto;
import org.mcxiaoke.douban.api.model.DoubanShuo;
import org.mcxiaoke.douban.api.model.DoubanUser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseTestCase extends BaseTestCase {

	public void testUserParse() throws IOException {
		InputStream is = openAssets("json/user.json");
		ObjectMapper om = new ObjectMapper();
		DoubanUser u = om.readValue(is, DoubanUser.class);
		assertNotNull(u);
		debug(u);
	}

	public void testAlbumParse() throws IOException {
		InputStream is = openAssets("json/album.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanAlbum a = om.readValue(is, DoubanAlbum.class);
		assertNotNull(a);
		debug(a);
	}

	public void testPhotoParse() throws IOException {
		InputStream is = openAssets("json/photo.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanPhoto a = om.readValue(is, DoubanPhoto.class);
		assertNotNull(a);
		debug(a);
	}

	public void testAlbumPhotosParse() throws IOException {
		InputStream is = openAssets("json/photos.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanAlbumPhotos a = om.readValue(is, DoubanAlbumPhotos.class);
		assertNotNull(a);
		debug(a);
	}

	public void testShuoParse() throws IOException {
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

	public void testCommentsParse() throws IOException {
		InputStream is = openAssets("json/comments.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanComments a = om.readValue(is, DoubanComments.class);
		assertNotNull(a);
		debug(a);
	}

	public void testEventsParse() throws IOException {
		InputStream is = openAssets("json/events.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanEvents a = om.readValue(is, DoubanEvents.class);
		assertNotNull(a);
		debug(a);
	}

	public void testOnlineParse() throws IOException {
		InputStream is = openAssets("json/onlines.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanOnlines a = om.readValue(is, DoubanOnlines.class);
		assertNotNull(a);
		debug(a);
	}

	public void testMailsParse() throws IOException {
		InputStream is = openAssets("json/mails.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanMails a = om.readValue(is, DoubanMails.class);
		assertNotNull(a);
		debug(a);
	}

	public void testNoteParse() throws IOException {
		InputStream is = openAssets("json/note.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanNote a = om.readValue(is, DoubanNote.class);
		assertNotNull(a);
		debug(a);
	}

	public void testNotesParse() throws IOException {
		InputStream is = openAssets("json/notes.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanNotes a = om.readValue(is, DoubanNotes.class);
		assertNotNull(a);
		debug(a);
	}

	public void testBookParse() throws IOException {
		InputStream is = openAssets("json/book.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanBook a = om.readValue(is, DoubanBook.class);
		assertNotNull(a);
		debug(a);
	}

	public void testBooksParse() throws IOException {
		InputStream is = openAssets("json/books.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanBookCollections a = om.readValue(is, DoubanBookCollections.class);
		assertNotNull(a);
		debug(a);
	}

	public void testMovieParse() throws IOException {
		InputStream is = openAssets("json/movie.json");
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		DoubanMovie a = om.readValue(is, DoubanMovie.class);
		assertNotNull(a);
		debug(a);
	}

}
