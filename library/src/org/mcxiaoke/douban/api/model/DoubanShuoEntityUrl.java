/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanShuoEntityUrl extends DoubanShuoEntityItemBase {
	@JsonProperty("url")
	private String shortUrl;
	@JsonProperty("expanded_url")
	private String webUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanShuoEntityUrls [indices=");
		builder.append(Arrays.toString(getIndices()));
		builder.append(", shortUrl=");
		builder.append(shortUrl);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append("]");
		return builder.toString();
	}

}
