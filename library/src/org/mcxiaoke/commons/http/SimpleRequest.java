/**
 * 
 */
package org.mcxiaoke.commons.http;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.mcxiaoke.commons.http.auth.AuthConfig;
import org.mcxiaoke.commons.http.util.HttpUtils;
import org.mcxiaoke.commons.util.StringUtils;
import org.scribe.model.OAuthConstants;

/**
 * @author mcxiaoke
 * 
 */
public class SimpleRequest {

	private static final String TAG = SimpleRequest.class.getSimpleName();
	private static final String OAUTH_PREFIX = "oauth_";

	private final String mOriginalUrl;
	private final String mUrl;
	private final Method mMethod;
	private final AuthConfig mAuthConfig;
	private final HashMap<String, String> mHeaders;
	private final ArrayList<Parameter> mParameters;
	private final ArrayList<Parameter> mQueryParameters;
	private final HashMap<String, FileHolder> mFileParameters;
	private HashMap<String, String> mOAuthParameters;
	private boolean mGzipEnalbed;

	public SimpleRequest(final SimpleRequest.RequestBuilder builder) {
		this.mOriginalUrl = builder.getUrl();
		this.mMethod = builder.getMethod();
		this.mAuthConfig = builder.getAuthorization();
		this.mHeaders = new HashMap<String, String>();
		this.mParameters = new ArrayList<Parameter>();
		this.mQueryParameters = new ArrayList<Parameter>();
		this.mFileParameters = new HashMap<String, SimpleRequest.FileHolder>();
		this.mOAuthParameters = new HashMap<String, String>();

		if (builder.getParameters() != null) {
			mParameters.addAll(builder.getParameters());
		}
		if (builder.getQueryParameters() != null) {
			mQueryParameters.addAll(builder.getQueryParameters());
		}
		if (builder.getFileParameters() != null) {
			mFileParameters.putAll(builder.getFileParameters());
		}
		this.mGzipEnalbed = builder.isGzipEnalbed();
		this.mUrl = SimpleHelper.extractUrlQueryParameters(mOriginalUrl,
				mQueryParameters);
	}

	public boolean isGzipEnabled() {
		return this.mGzipEnalbed;
	}

	public void enableGzip() {
		this.mGzipEnalbed = true;
	}

	public void disableGzip() {
		this.mGzipEnalbed = false;
	}

	public String getUrl() {
		return mUrl;
	}

	public Method getMethod() {
		return mMethod;
	}

	public String getMethodName() {
		return HttpUtils.getMethodName(mMethod);
	}

	public AuthConfig getAuthConfig() {
		return mAuthConfig;
	}

	public final String getHeader(String name) {
		return mHeaders.get(name);
	}

	public Map<String, String> getHeaders() {
		return mHeaders;
	}

	public void addHeader(String name, String value) {
		mHeaders.put(name, value);
	}

	public void addHeaders(Map<String, String> headers) {
		if (headers != null) {
			this.mHeaders.putAll(headers);
		}
	}

	public void removeHeader(String key) {
		mHeaders.remove(key);
	}

	public void removeAllHeaders() {
		mHeaders.clear();
	}

	public void addParameter(String name, String value) {
		if (StringUtils.isNotEmpty(name)) {
			mParameters.add(new Parameter(name, value));
		}
	}

	public void addQueryParameter(String name, String value) {
		if (StringUtils.isNotEmpty(name)) {
			mQueryParameters.add(new Parameter(name, value));
		}
	}

	public void addParameters(Collection<? extends Parameter> params) {
		if (params != null) {
			this.mParameters.addAll(params);
		}
	}

	public void addQueryParameters(Collection<? extends Parameter> params) {
		if (params != null) {
			this.mQueryParameters.addAll(params);
		}
	}

	public void addParameters(Map<String, String> params) {
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				Parameter p = new Parameter(entry.getKey(), entry.getValue());
				this.mParameters.add(p);
			}
		}
	}

	public void addQueryParameters(Map<String, String> params) {
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				Parameter p = new Parameter(entry.getKey(), entry.getValue());
				this.mQueryParameters.add(p);
			}
		}
	}

	public void addFileParameter(String key, File file)
			throws FileNotFoundException {
		addFileParameter(key, new FileInputStream(file), file.getName());
	}

	public void addFileParameter(String key, byte[] bytes) {
		addFileParameter(key, new ByteArrayInputStream(bytes));
	}

	public void addFileParameter(String name, InputStream stream) {
		addFileParameter(name, stream, null);
	}

	public void addFileParameter(String key, InputStream stream, String fileName) {
		addFileParameter(key, stream, fileName);
	}

	public void addFileParameter(String key, InputStream stream,
			String fileName, String contentType) {
		if (StringUtils.isNotEmpty(key) && stream != null) {
			mFileParameters.put(key, new FileHolder(stream, fileName,
					contentType));
		}
	}

	public void addOAuthParameter(String key, String value) {
		if (isValidOAuthKey(key)) {
			mOAuthParameters.put(key, value);

		}
	}

	public void addOAuthParameters(Map<String, String> parameters) {
		if (parameters != null && parameters.size() > 0) {
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				String key = entry.getKey();
				if (isValidOAuthKey(key)) {
				}
				String value = entry.getValue();
				mOAuthParameters.put(key, value);
			}
		}
	}

	public List<Parameter> getOAuthParameters() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		for (Map.Entry<String, String> entry : mOAuthParameters.entrySet()) {
			parameters.add(new Parameter(entry.getKey(), entry.getValue()));
		}
		return parameters;
	}

	public Map<String, String> getOAuthParametersMap() {
		return this.mOAuthParameters;
	}

	public List<Parameter> getParameters() {
		return this.mParameters;
	}

	public List<Parameter> getQueryParameters() {
		return this.mQueryParameters;
	}

	public HashMap<String, FileHolder> getFileParameters() {
		return mFileParameters;
	}

	public boolean hasParameters() {
		return mParameters.size() > 0;
	}

	public boolean hasQueryParameters() {
		return mQueryParameters.size() > 0;
	}

	public boolean hasFileParameters() {
		return mFileParameters.size() > 0;
	}

	public boolean hasOAuthParameters() {
		return mOAuthParameters.size() > 0;
	}

	public void removeAllParameters() {
		mParameters.clear();
		mQueryParameters.clear();
		mFileParameters.clear();
	}

	private boolean isValidOAuthKey(String key) {
		return key != null
				&& (key.startsWith(OAUTH_PREFIX) || key
						.equals(OAuthConstants.SCOPE));
	}

	/**************** REQUEST BUILDER ****************************/
	public final static class RequestBuilder {
		private String url;
		private Method method;
		private AuthConfig oauthConfig;
		private HashMap<String, String> headers;
		private ArrayList<Parameter> parameters;
		private ArrayList<Parameter> queryParameters;
		private HashMap<String, FileHolder> fileParameters;
		private boolean gzipEnalbed;

		public static RequestBuilder create() {
			return new RequestBuilder();
		}

		public RequestBuilder() {
			this.headers = new HashMap<String, String>();
			this.queryParameters = new ArrayList<Parameter>();
			this.parameters = new ArrayList<Parameter>();
			this.fileParameters = new HashMap<String, SimpleRequest.FileHolder>();
		}

		public SimpleRequest build() {
			return new SimpleRequest(this);
		}

		public String getUrl() {
			return url;
		}

		public Method getMethod() {
			return method;
		}

		public AuthConfig getAuthorization() {
			return oauthConfig;
		}

		public Map<String, String> getHeaders() {
			return headers;
		}

		public List<Parameter> getParameters() {
			return parameters;
		}

		public List<Parameter> getQueryParameters() {
			return queryParameters;
		}

		public Map<String, FileHolder> getFileParameters() {
			return fileParameters;
		}

		public boolean isGzipEnalbed() {
			return gzipEnalbed;
		}

		public RequestBuilder url(String url) {
			this.url = url;
			return this;
		}

		public RequestBuilder url(URL url) {
			this.url = url.toString();
			return this;
		}

		public RequestBuilder url(URI uri) {
			this.url = uri.toString();
			return this;
		}

		public RequestBuilder method(Method method) {
			this.method = method;
			return this;
		}

		public RequestBuilder authorization(final AuthConfig authorization) {
			this.oauthConfig = authorization;
			return this;
		}

		public RequestBuilder basicAuth(final String userName,
				final String password) {
			this.oauthConfig = new AuthConfig(userName, password);
			return this;
		}

		public RequestBuilder oauth(final String apiKey,
				final String apiSecret, final String accessToken,
				final String accessTokenSecret) {
			this.oauthConfig = new AuthConfig(apiKey, apiSecret, accessToken,
					accessTokenSecret);
			return this;
		}

		public RequestBuilder oauth2(final String accessToken) {
			this.oauthConfig = new AuthConfig(accessToken);
			return this;
		}

		public RequestBuilder header(String name, String value) {
			this.headers.put(name, value);
			return this;
		}

		public RequestBuilder headers(Map<String, String> headers) {
			if (headers != null) {
				this.headers.putAll(headers);
			}
			return this;
		}

		public RequestBuilder param(String key, String value) {
			if (StringUtils.isNotEmpty(key)) {
				parameters.add(new Parameter(key, value));
			}
			return this;
		}

		public RequestBuilder param(NameValuePair pair) {
			if (pair != null) {
				parameters.add(new Parameter(pair));
			}
			return this;
		}

		public void params(Collection<? extends Parameter> params) {
			if (params != null) {
				parameters.addAll(params);
			}
		}

		public RequestBuilder param(Map<String, String> params) {
			if (params != null) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					Parameter p = new Parameter(entry.getKey(),
							entry.getValue());
					this.parameters.add(p);
				}
			}
			return this;
		}

		public RequestBuilder query(String key, String value) {
			if (StringUtils.isNotEmpty(key)) {
				parameters.add(new Parameter(key, value));
			}
			return this;
		}

		public RequestBuilder query(NameValuePair pair) {
			if (pair != null) {
				parameters.add(new Parameter(pair));
			}
			return this;
		}

		public void querys(Collection<? extends Parameter> params) {
			if (params != null) {
				parameters.addAll(params);
			}
		}

		public RequestBuilder querys(Map<String, String> params) {
			if (params != null) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					Parameter p = new Parameter(entry.getKey(),
							entry.getValue());
					this.parameters.add(p);
				}
			}
			return this;
		}

		public RequestBuilder param(String key, File file) {
			try {
				param(key, new FileInputStream(file), file.getName());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return this;
		}

		public RequestBuilder param(String key, byte[] bytes) {
			param(key, new ByteArrayInputStream(bytes));
			return this;
		}

		public RequestBuilder param(String name, InputStream stream) {
			param(name, stream, null);
			return this;
		}

		public RequestBuilder param(String key, InputStream stream,
				String fileName) {
			param(key, stream, fileName, null);
			return this;
		}

		public RequestBuilder param(String key, InputStream stream,
				String fileName, String contentType) {
			if (StringUtils.isNotEmpty(key) && stream != null) {
				fileParameters.put(key, new FileHolder(stream, fileName,
						contentType));
			}
			return this;
		}

		public void gzip(boolean enable) {
			this.gzipEnalbed = enable;
		}

	}

	static class FileHolder {
		private static final String DEFAULT_FILENAME = "filename";
		public final InputStream inputStream;
		public final String fileName;
		public final String contentType;

		public FileHolder(InputStream inputStream, String fileName,
				String contentType) {
			this.inputStream = inputStream;
			this.fileName = (fileName == null) ? DEFAULT_FILENAME : fileName;
			this.contentType = contentType;
		}
	}

}
