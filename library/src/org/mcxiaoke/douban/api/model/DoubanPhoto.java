/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanPhoto extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("alt")
	private String alt;
	@JsonProperty("album_title")
	private String albumTitle;
	@JsonProperty("desc")
	private String desc;
	@JsonProperty("created")
	private Date created;
	@JsonProperty("updated")
	private Date updated;
	@JsonProperty("album_id")
	private long albumId;
	@JsonProperty("position")
	private int position;
	@JsonProperty("prev_photo")
	private long prevPhoto;
	@JsonProperty("next_photo")
	private long nextPhoto;
	@JsonProperty("liked")
	private boolean liked;
	@JsonProperty("icon")
	private String icon;
	@JsonProperty("thumb")
	private String thumb;
	@JsonProperty("cover")
	private String cover;
	@JsonProperty("image")
	private String image;
	@JsonProperty("resc_count")
	private int recsCount;
	@JsonProperty("liked_count")
	private int likedCount;
	@JsonProperty("comments_count")
	private int commentsCount;
	@JsonProperty("privacy")
	private String privacy;
	@JsonProperty("author")
	private DoubanUser author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

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

	public long getPrevPhoto() {
		return prevPhoto;
	}

	public void setPrevPhoto(long prevPhoto) {
		this.prevPhoto = prevPhoto;
	}

	public long getNextPhoto() {
		return nextPhoto;
	}

	public void setNextPhoto(long nextPhoto) {
		this.nextPhoto = nextPhoto;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRecsCount() {
		return recsCount;
	}

	public void setRecsCount(int recsCount) {
		this.recsCount = recsCount;
	}

	public int getLikedCount() {
		return likedCount;
	}

	public void setLikedCount(int likedCount) {
		this.likedCount = likedCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public DoubanUser getAuthor() {
		return author;
	}

	public void setAuthor(DoubanUser author) {
		this.author = author;
	}

}
