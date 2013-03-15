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
	private String expandedHref;
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

	public String getExpandedHref() {
		return expandedHref;
	}

	public void setExpandedHref(String expandedHref) {
		this.expandedHref = expandedHref;
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

}
