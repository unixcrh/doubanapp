/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanError extends AbstractModel {
	@JsonProperty("code")
	private int code;
	@JsonProperty("msg")
	private String message;
	@JsonProperty("request")
	private String request;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "DoubanError [code=" + code + ", message=" + message
				+ ", request=" + request + "]";
	}

}
