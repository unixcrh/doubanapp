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

	public DoubanResponse(final SimpleResponse response,
			final TypeReference<T> type) {
		from(response, type);
	}

	public DoubanResponse(final SimpleResponse response, final Class<T> clazz) {
		from(response, clazz);
	}

	public void from(final SimpleResponse response, final TypeReference<T> type) {
		statusCode = response.getStatusCode();
		statusMessage = response.getStatusMessage();
		if (response.isSuccess()) {
			handleResponse(response, type);
		} else {
			handleError(response);
		}
	}

	public void from(final SimpleResponse response, final Class<T> clazz) {
		statusCode = response.getStatusCode();
		statusMessage = response.getStatusMessage();
		if (response.isSuccess()) {
			handleResponse(response, clazz);
		} else {
			handleError(response);
		}
	}

	private void handleResponse(SimpleResponse response, TypeReference<T> type) {
		this.errorCode = DoubanErrorCode.CODE_OK;
		try {
			data = DoubanHelper.parseArrayResponse(response, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleResponse(SimpleResponse response, Class<T> clazz) {
		this.errorCode = DoubanErrorCode.CODE_OK;
		try {
			data = DoubanHelper.parseSingleResponse(response, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleError(final SimpleResponse response) {
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
	}

	private DoubanError parseError(SimpleResponse response) {
		try {
			return DoubanHelper.parseError(response);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
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

}
