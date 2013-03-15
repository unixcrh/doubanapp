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
	private String webUrl;
	@JsonProperty("album_title")
	private String albumTitle;
	@JsonProperty("desc")
	private String description;
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonProperty("created")
	private Date createdAt;
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonProperty("updated")
	private Date updatedAt;
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
	private int recommendedCount;
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

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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

	public int getRecommendedCount() {
		return recommendedCount;
	}

	public void setRecommendedCount(int recommendedCount) {
		this.recommendedCount = recommendedCount;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanAlbum [id=");
		builder.append(id);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", albumTitle=");
		builder.append(albumTitle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", liked=");
		builder.append(liked);
		builder.append(", icon=");
		builder.append(icon);
		builder.append(", thumb=");
		builder.append(thumb);
		builder.append(", cover=");
		builder.append(cover);
		builder.append(", image=");
		builder.append(image);
		builder.append(", recommendedCount=");
		builder.append(recommendedCount);
		builder.append(", likedCount=");
		builder.append(likedCount);
		builder.append(", commentsCount=");
		builder.append(commentsCount);
		builder.append(", privacy=");
		builder.append(privacy);
		builder.append(", author=");
		builder.append(author);
		builder.append("]");
		return builder.toString();
	}

}
