package org.mcxiaoke.commons.http;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.mcxiaoke.commons.util.AssertUtils;

public class SimpleHttpParams {
	private static final String DEFAULT_ENCODING = HTTP.UTF_8;
	private static final Charset DEFAULT_CHARSET = Charsets.UTF_8;
	private static final String DEFAULT_FILENAME = "filename";

	protected ArrayList<NameValuePair> textParams;
	protected ConcurrentHashMap<String, FileHolder> binaryParams;
	protected ConcurrentHashMap<String, ArrayList<String>> multiParams;

	public SimpleHttpParams() {
		initialize();
	}

	public SimpleHttpParams(String key, String value) {
		initialize();
		add(key, value);
	}

	public SimpleHttpParams(Map<String, String> source) {
		initialize();
		for (Map.Entry<String, String> entry : source.entrySet()) {
			add(entry.getKey(), entry.getValue());
		}
	}

	public SimpleHttpParams(List<NameValuePair> source) {
		initialize();
		addAll(source);
	}

	private void initialize() {
		textParams = new ArrayList<NameValuePair>();
		binaryParams = new ConcurrentHashMap<String, FileHolder>();
		multiParams = new ConcurrentHashMap<String, ArrayList<String>>();
	}

	public void add(String key, String value) {
		AssertUtils.notNull(key);
		textParams.add(new BasicNameValuePair(key, value));
	}

	public void add(NameValuePair pair) {
		AssertUtils.notNull(pair);
		textParams.add(pair);
	}

	public void addAll(Collection<? extends NameValuePair> params) {
		AssertUtils.notNull(params);
		textParams.addAll(params);
	}

	public void add(String key, File file) throws FileNotFoundException {
		add(key, new FileInputStream(file), file.getName());
	}

	public void add(String key, byte[] bytes) {
		add(key, new ByteArrayInputStream(bytes));
	}

	public void add(String key, InputStream stream) {
		add(key, stream, null);
	}

	public void add(String key, InputStream stream, String fileName) {
		add(key, stream, fileName, null);
	}

	public void add(String key, InputStream stream, String fileName,
			String contentType) {
		AssertUtils.notNull(key);
		AssertUtils.notNull(stream);
		binaryParams.put(key, new FileHolder(stream, fileName, contentType));
	}

	public void add(String key, ArrayList<String> values) {
		AssertUtils.notNull(key);
		AssertUtils.notNull(values);
		multiParams.put(key, values);
	}

	public void remove(String key) {
		AssertUtils.notNull(key);
		textParams.remove(key);
		binaryParams.remove(key);
		multiParams.remove(key);
	}

	public HttpEntity toEntity() {
		HttpEntity entity = null;
		if (binaryParams.isEmpty()) {
			entity = encodeFormEntity();
		} else {
			entity = encodeMultiPart();
		}

		return entity;
	}

	private HttpEntity encodeMultiPart() {
		MultipartEntity entity = new MultipartEntity();
		encodeTextParams(entity);
		encodeMultiParams(entity);
		encodeBinaryParams(entity);
		return entity;
	}

	private void encodeTextParams(MultipartEntity multipartEntity) {
		for (NameValuePair pair : textParams) {
			multipartEntity.addPart(pair.getName(),
					StringBody.create(pair.getValue(), DEFAULT_CHARSET));
		}
	}

	private void encodeMultiParams(MultipartEntity multipartEntity) {
		for (ConcurrentHashMap.Entry<String, ArrayList<String>> entry : multiParams
				.entrySet()) {
			ArrayList<String> values = entry.getValue();
			for (String value : values) {
				multipartEntity.addPart(entry.getKey(),
						StringBody.create(value, Charset.forName(HTTP.UTF_8)));
			}
		}
	}

	private void encodeBinaryParams(MultipartEntity multipartEntity) {
		for (ConcurrentHashMap.Entry<String, FileHolder> entry : binaryParams
				.entrySet()) {
			FileHolder file = entry.getValue();
			if (file.inputStream != null) {
				if (file.contentType != null) {
					multipartEntity.addPart(entry.getKey(),
							new InputStreamBody(file.inputStream,
									file.contentType, file.getFileName()));
				} else {
					multipartEntity.addPart(
							entry.getKey(),
							new InputStreamBody(file.inputStream, file
									.getFileName()));
				}
			}
		}
	}

	private HttpEntity encodeFormEntity() {
		HttpEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(getParamsList(), DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return entity;
	}

	protected List<NameValuePair> getParamsList() {
		List<NameValuePair> lparams = new LinkedList<NameValuePair>();
		lparams.addAll(textParams);

		for (ConcurrentHashMap.Entry<String, ArrayList<String>> entry : multiParams
				.entrySet()) {
			ArrayList<String> values = entry.getValue();
			for (String value : values) {
				lparams.add(new BasicNameValuePair(entry.getKey(), value));
			}
		}

		return lparams;
	}

	protected String getParamString() {
		return URLEncodedUtils.format(getParamsList(), DEFAULT_ENCODING);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestParams [textParams=");
		builder.append(textParams);
		builder.append(", binaryParams=");
		builder.append(binaryParams);
		builder.append(", multiParams=");
		builder.append(multiParams);
		builder.append("]");
		return builder.toString();
	}

	private static class FileHolder {
		InputStream inputStream;
		private String fileName;
		String contentType;

		public FileHolder(InputStream inputStream, String fileName,
				String contentType) {
			this.inputStream = inputStream;
			this.fileName = fileName;
			this.contentType = contentType;
		}

		public String getFileName() {
			if (fileName != null) {
				return fileName;
			} else {
				return DEFAULT_FILENAME;
			}
		}
	}
}
