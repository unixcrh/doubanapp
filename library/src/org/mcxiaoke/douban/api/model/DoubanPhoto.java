/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanPhoto extends DoubanAlbum {
	@JsonProperty("album_id")
	private long albumId;
	@JsonProperty("position")
	private int position;
	@JsonProperty("prev_photo")
	private long prevPhotoId;
	@JsonProperty("next_photo")
	private long nextPhotoId;

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public long getPrevPhotoId() {
		return prevPhotoId;
	}

	public void setPrevPhotoId(long prevPhotoId) {
		this.prevPhotoId = prevPhotoId;
	}

	public long getNextPhotoId() {
		return nextPhotoId;
	}

	public void setNextPhotoId(long nextPhotoId) {
		this.nextPhotoId = nextPhotoId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanPhoto [albumId=");
		builder.append(albumId);
		builder.append(", position=");
		builder.append(position);
		builder.append(", prevPhotoId=");
		builder.append(prevPhotoId);
		builder.append(", nextPhotoId=");
		builder.append(nextPhotoId);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getWebUrl()=");
		builder.append(getWebUrl());
		builder.append(", getAlbumTitle()=");
		builder.append(getAlbumTitle());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getCreatedAt()=");
		builder.append(getCreatedAt());
		builder.append(", getUpdatedAt()=");
		builder.append(getUpdatedAt());
		builder.append(", isLiked()=");
		builder.append(isLiked());
		builder.append(", getIcon()=");
		builder.append(getIcon());
		builder.append(", getThumb()=");
		builder.append(getThumb());
		builder.append(", getCover()=");
		builder.append(getCover());
		builder.append(", getImage()=");
		builder.append(getImage());
		builder.append(", getRecommendedCount()=");
		builder.append(getRecommendedCount());
		builder.append(", getLikedCount()=");
		builder.append(getLikedCount());
		builder.append(", getCommentsCount()=");
		builder.append(getCommentsCount());
		builder.append(", getPrivacy()=");
		builder.append(getPrivacy());
		builder.append(", getAuthor()=");
		builder.append(getAuthor());
		builder.append("]");
		return builder.toString();
	}

}
