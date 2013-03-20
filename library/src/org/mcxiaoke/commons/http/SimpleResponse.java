/**
 * 
 */
package org.mcxiaoke.commons.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.mcxiaoke.commons.util.LogUtils;

/**
 * @author mcxiaoke
 * 
 */
public class SimpleResponse {
	private static final boolean DEBUG = true;
	private static final String TAG = SimpleResponse.class.getSimpleName();

	private static void debug(String message) {
		LogUtils.v(TAG, message);
	}

	private static final long INVALID_CONTENT_LENGTH = -1L;

	private final StatusLine statusLine;
	private final int statusCode;
	private final String statusMessage;

	private final Header[] requestHeaders;
	private final Header[] responseHeaders;

	private final HttpRequest request;
	private final HttpResponse response;
	private final BufferedHttpEntity entity;

	public SimpleResponse(final HttpRequest request, final HttpResponse response) {
		this.request = request;
		this.response = response;
		this.response.getEntity();
		this.statusLine = this.response.getStatusLine();
		this.statusCode = this.statusLine.getStatusCode();
		this.statusMessage = this.statusLine.getReasonPhrase();
		this.requestHeaders = request.getAllHeaders();
		this.responseHeaders = response.getAllHeaders();
		this.entity = wrapEntity(this.response);
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public boolean isSuccessStatusCode() {
		return StatusCodes.isSuccess(statusCode);
	}

	public String getStatusMessage() {
		return this.statusMessage;
	}

	public long getContentLength() {
		if (this.entity != null) {
			return this.entity.getContentLength();
		} else {
			return INVALID_CONTENT_LENGTH;
		}
	}

	public InputStream getContent() throws IOException {
		if (this.entity != null) {
			return this.entity.getContent();
		} else {
			return null;
		}
	}

	public String getAsString() throws IOException {
		if (this.entity != null) {
			return EntityUtils.toString(this.entity, HTTP.UTF_8);
		} else {
			return null;
		}
	}

	public byte[] getAsByteArray() throws IOException {
		if (this.entity != null) {
			return EntityUtils.toByteArray(this.entity);
		} else {
			return null;
		}
	}

	private BufferedHttpEntity wrapEntity(final HttpResponse response) {
		BufferedHttpEntity wrappedEntity = null;
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			try {
				wrappedEntity = new BufferedHttpEntity(httpEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return wrappedEntity;
	}

}
