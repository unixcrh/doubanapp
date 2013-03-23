/**
 * 
 */
package org.mcxiaoke.douban;

import android.os.Bundle;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanResponse<T> {
	private final T data;
	private final int errorCode;
	private final String errorMessage;
	private final Bundle extras;

	public DoubanResponse(final T data) {
		this(data, DoubanCodes.CODE_OK, null, null);
	}

	public DoubanResponse(final T data, final int errorCode) {
		this(data, errorCode, null, null);
	}

	public DoubanResponse(final T data, final int errorCode,
			final String errorMessage) {
		this(data, errorCode, errorMessage, null);
	}

	public DoubanResponse(final T data, final int errorCode,
			final String errorMessage, final Bundle extras) {
		this.data = data;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.extras = new Bundle();
		if (extras != null) {
			this.extras.putAll(extras);
		}
	}

	public T getData() {
		return data;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Bundle getExtras() {
		return extras;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanResponse [data=");
		builder.append(data);
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
