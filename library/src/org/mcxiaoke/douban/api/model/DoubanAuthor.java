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
	private String alt;
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

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public DoubanImage getAvatars() {
		return avatars;
	}

	public void setAvatars(DoubanImage avatars) {
		this.avatars = avatars;
	}

}
