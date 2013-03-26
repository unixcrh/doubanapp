/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.io.File;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanShuoUpdate extends AbstractModel {
	private String text; // true
	private File image;
	private String recTitle;
	private String recUrl;
	private String recDesc;
	private String recImageUrl;

	public DoubanShuoUpdate() {

	}

	public DoubanShuoUpdate(String text) {
		this.text = text;
	}

	public DoubanShuoUpdate(String text, File image) {
		this.text = text;
		this.image = image;
	}

	public boolean hasImage() {
		return image != null;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
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
		builder.append("StatusUpdate ");
		builder.append(", text=");
		builder.append(text);
		builder.append(", image=");
		builder.append(image);
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
