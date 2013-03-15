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
public class DoubanShuoEntityTopic extends DoubanShuoEntityItemBase {
	@JsonProperty("text")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanShuoEntityTopics [indices=");
		builder.append(Arrays.toString(getIndices()));
		builder.append(", text=");
		builder.append(text);
		builder.append("]");
		return builder.toString();
	}

}
