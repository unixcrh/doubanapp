/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanImage extends AbstractModel {
	@JsonProperty("small")
	private String small;
	@JsonProperty("large")
	private String large;
	@JsonProperty("medium")
	private String medium;

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanImage [small=");
		builder.append(small);
		builder.append(", large=");
		builder.append(large);
		builder.append(", medium=");
		builder.append(medium);
		builder.append("]");
		return builder.toString();
	}

}
