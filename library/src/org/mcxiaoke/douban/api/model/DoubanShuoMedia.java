/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanShuoMedia extends AbstractModel {
	@JsonProperty("src")
	private String src;
	@JsonProperty("secret_pid")
	private String secretPid;
	@JsonProperty("original_src")
	private String imageUrl;
	@JsonProperty("href")
	private String webUrl;
	@JsonProperty("type")
	private String type;
	@JsonProperty("imgsrc")
	private String mediaUrl;
	@JsonProperty("title")
	private String title;
	@JsonProperty("artist")
	private String artist;
	@JsonProperty("album")
	private String album;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSecretPid() {
		return secretPid;
	}

	public void setSecretPid(String secretPid) {
		this.secretPid = secretPid;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanShuoMedia [src=");
		builder.append(src);
		builder.append(", secretPid=");
		builder.append(secretPid);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", type=");
		builder.append(type);
		builder.append(", mediaUrl=");
		builder.append(mediaUrl);
		builder.append(", title=");
		builder.append(title);
		builder.append(", artist=");
		builder.append(artist);
		builder.append(", album=");
		builder.append(album);
		builder.append("]");
		return builder.toString();
	}

}
