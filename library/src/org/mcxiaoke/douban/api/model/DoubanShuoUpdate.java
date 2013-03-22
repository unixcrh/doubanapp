/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Arrays;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanShuoUpdate extends AbstractModel {
	private String source; // true apikey
	private String text; // true
	private byte[] image;
	private String recTitle;
	private String recUrl;
	private String recDesc;
	private String recImageUrl;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getRecTitle() {
		return recTitle;
	}

	public void setRecTitle(String recTitle) {
		this.recTitle = recTitle;
	}

	public String getRecUrl() {
		return recUrl;
	}

	public void setRecUrl(String recUrl) {
		this.recUrl = recUrl;
	}

	public String getRecDesc() {
		return recDesc;
	}

	public void setRecDesc(String recDesc) {
		this.recDesc = recDesc;
	}

	public String getRecImageUrl() {
		return recImageUrl;
	}

	public void setRecImageUrl(String recImageUrl) {
		this.recImageUrl = recImageUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusUpdate [source=");
		builder.append(source);
		builder.append(", text=");
		builder.append(text);
		builder.append(", image=");
		builder.append(Arrays.toString(image));
		builder.append(", recTitle=");
		builder.append(recTitle);
		builder.append(", recUrl=");
		builder.append(recUrl);
		builder.append(", recDesc=");
		builder.append(recDesc);
		builder.append(", recImageUrl=");
		builder.append(recImageUrl);
		builder.append("]");
		return builder.toString();
	}

}
