package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.io.InputStream;

import org.mcxiaoke.douban.api.model.DoubanUser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseTestCase extends BaseTestCase {

	public void testUser() throws IOException {
		InputStream is = openAssets("json/user.json");
		ObjectMapper om = new ObjectMapper();
		DoubanUser u = om.readValue(is, DoubanUser.class);
		debug(u);
		assertNotNull(u);
	}

}
