/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanRelation extends AbstractModel {
	@JsonProperty("source")
	private DoubanRelationItem source;
	@JsonProperty("target")
	private DoubanRelationItem target;

	public DoubanRelationItem getSource() {
		return source;
	}

	public void setSource(DoubanRelationItem source) {
		this.source = source;
	}

	public DoubanRelationItem getTarget() {
		return target;
	}

	public void setTarget(DoubanRelationItem target) {
		this.target = target;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanRelation [source=");
		builder.append(source);
		builder.append(", target=");
		builder.append(target);
		builder.append("]");
		return builder.toString();
	}

}
