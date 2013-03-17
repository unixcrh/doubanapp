/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanMusicTrack extends AbstractModel {
	@JsonProperty("index")
	private int index;
	@JsonProperty("name")
	private String name;
	@JsonProperty("title")
	private String title;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanMusicTrack [index=");
		builder.append(index);
		builder.append(", name=");
		builder.append(name);
		builder.append(", title=");
		builder.append(title);
		builder.append("]");
		return builder.toString();
	}

}
