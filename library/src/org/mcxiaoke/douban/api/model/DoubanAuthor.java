/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanAuthor extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("avatars")
	private DoubanImage avatars;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public DoubanImage getAvatars() {
		return avatars;
	}

	public void setAvatars(DoubanImage avatars) {
		this.avatars = avatars;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanAuthor [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", avatars=");
		builder.append(avatars);
		builder.append("]");
		return builder.toString();
	}

}
