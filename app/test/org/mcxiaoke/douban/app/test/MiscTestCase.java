package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class MiscTestCase extends BaseTestCase {

	public void testHttpHead() throws IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("https://api.douban.com");
		HttpResponse response = client.execute(request);
		if (response != null) {
			HttpEntity entity = response.getEntity();
			error("entity=" + entity);
			assertNotNull(entity);
			InputStream is = entity.getContent();
			error("inputstream=" + is);
			assertNotNull(is);
		}
	}

}
