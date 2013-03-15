package org.mcxiaoke.douban.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoubanShuoAttachment extends AbstractModel {
	@JsonProperty("description")
	private String description;
	@JsonProperty("title")
	private String title;
	@JsonProperty("media")
	private List<DoubanShuoMedia> media;
	@JsonProperty("expanded_href")
	private String webUrl;
	@JsonProperty("href")
	private String shortUrl;
	@JsonProperty("caption")
	private String caption;
	@JsonProperty("type")
	private String type;
	@JsonProperty("properties")
	private List<DoubanShuoProperty> properties;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<DoubanShuoMedia> getMedia() {
		return media;
	}

	public void setMedia(List<DoubanShuoMedia> media) {
		this.media = media;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<DoubanShuoProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<DoubanShuoProperty> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanShuoAttachment [description=");
		builder.append(description);
		builder.append(", title=");
		builder.append(title);
		builder.append(", media=");
		builder.append(media);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", shortUrl=");
		builder.append(shortUrl);
		builder.append(", caption=");
		builder.append(caption);
		builder.append(", type=");
		builder.append(type);
		builder.append(", properties=");
		builder.append(properties);
		builder.append("]");
		return builder.toString();
	}

}
