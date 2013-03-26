/**
 * 
 */
package org.mcxiaoke.douban;

import java.io.IOException;

import org.mcxiaoke.commons.http.SimpleResponse;
import org.mcxiaoke.commons.http.StatusCodes;
import org.mcxiaoke.douban.api.model.DoubanError;

import android.os.Bundle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanResponse<T> implements IDoubanResponse<T> {
	private T data;
	private int statusCode;
	private String statusMessage;
	private int errorCode;
	private String errorMessage;
	private Bundle extras;

	public DoubanResponse(int errorCode) {
		this.errorCode = errorCode;
	}

	public DoubanResponse() {
		this(DoubanErrorCode.CODE_OK);
	}

	public <K> DoubanResponse(final SimpleResponse response, final Object type)
			throws DoubanException, IOException {
		this.statusCode = response.getStatusCode();
		this.statusMessage = response.getStatusMessage();
		if (response.isSuccess()) {
			handleResponse(response, type);
		} else {
			handleError(response);
		}
	}

	private void handleResponse(SimpleResponse response, final Object type)
			throws IOException {
		this.errorCode = DoubanErrorCode.CODE_OK;
		data = jsonParse(response, type);
	}

	private void handleError(final SimpleResponse response)
			throws DoubanException {
		DoubanError error = parseError(response);
		if (error != null) {
			this.errorCode = error.getCode();
			this.errorMessage = error.getMessage();
		} else {
			if (StatusCodes.isServerError(response.getStatusCode())) {
				this.errorCode = DoubanErrorCode.CODE_SERVER_ERROR;
			} else {
				this.errorCode = DoubanErrorCode.CODE_UNKOWN_ERROR;
			}
		}
		// TODO 
//		throw new DoubanException(this.errorCode, this.errorMessage);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public Bundle getExtras() {
		return extras;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setExtras(Bundle extras) {
		this.extras = extras;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanResponse [data=");
		builder.append(data);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append(", statusMessage=");
		builder.append(statusMessage);
		builder.append(", errorCode=");
		builder.append(errorCode);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append(", extras=");
		builder.append(extras);
		builder.append("]");
		return builder.toString();
	}

	private static DoubanError parseError(SimpleResponse response) {
		try {
			return jsonParse(response, DoubanError.class);
		} catch (IOException e) {
			return null;
		}
	}

	// T data type
	@SuppressWarnings("unchecked")
	private static <T> T jsonParse(SimpleResponse response, final Object type)
			throws IOException {
		ObjectMapper om = getObjectMapper();
		if (type instanceof Class) {
			final Class<T> clazz = (Class<T>) type;
			return om.readValue(response.getContent(), clazz);
		} else {
			final TypeReference<T> typeRef = (TypeReference<T>) type;
			return om.readValue(response.getContent(), typeRef);
		}
	}

	private static ObjectMapper getObjectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return om;
	}

}
