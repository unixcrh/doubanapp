package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class MiscTestCase extends BaseTestCase {

	public void atestHttpHead() throws IOException {
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

	public void testSetProxyProperties() throws IOException {
		// 此方式设置代理只适用于HttpURLConnection，对HttpClient无效
		Properties systemSettings = System.getProperties();
		systemSettings.put("http.proxyHost", "10.0.0.172");
		systemSettings.put("http.proxyPort", "80"); // use actual proxy port
		try {
			URL url = new URL("http://www.baidu.com");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			conn.connect();
			int code = conn.getResponseCode();
			debug("testSetProxyProperties responseCode=" + code);
			assertTrue(code >= 200);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
