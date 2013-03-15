/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import org.mcxiaoke.douban.api.parser.DateDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 豆瓣相册Model类
 * 
 * @author mcxiaoke
 * 
 */
public class DoubanAlbum extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("alt")
	private String alt;
	@JsonProperty("album_title")
	private String albumTitle;
	@JsonProperty("desc")
	private String desc;
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonProperty("created")
	private Date created;
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonProperty("updated")
	private Date updated;
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
	@JsonProperty("recs_count")
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
