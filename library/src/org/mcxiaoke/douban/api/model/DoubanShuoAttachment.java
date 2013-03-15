package org.mcxiaoke.douban.api.model;

import java.util.List;


public class DoubanShuoAttachment extends AbstractModel {
	private String description;
	private String title;
	private List<DoubanShuoMedia> media;
	private String expandedHref;
	private String caption;
	private String type;
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
