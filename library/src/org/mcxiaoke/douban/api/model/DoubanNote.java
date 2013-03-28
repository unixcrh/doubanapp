/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;
import java.util.List;

import org.mcxiaoke.douban.api.parser.DoubanDateDeserializer;
import org.mcxiaoke.douban.api.parser.DoubanContentPhotosDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanNote extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("can_reply")
	private boolean canReply;
	@JsonProperty("privacy")
	private String privacy;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("content")
	private String content;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("publish_time")
	private Date createdAt;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("update_time")
	private Date updatedAt;
	@JsonProperty("resc_count")
	private int recommendedCount;
	@JsonProperty("comments_count")
	private int commentsCount;
	@JsonProperty("liked_count")
	private int likedCount;
	@JsonProperty("author")
	private List<DoubanUser> authors;
	@JsonDeserialize(using = DoubanContentPhotosDeserializer.class)
	@JsonProperty("photos")
	private DoubanContentPhotos photos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public boolean isCanReply() {
		return canReply;
	}

	public void setCanReply(boolean canReply) {
		this.canReply = canReply;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getRecommendedCount() {
		return recommendedCount;
	}

	public void setRecommendedCount(int recommendedCount) {
		this.recommendedCount = recommendedCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public int getLikedCount() {
		return likedCount;
	}

	public void setLikedCount(int likedCount) {
		this.likedCount = likedCount;
	}

	public List<DoubanUser> getAuthors() {
		return authors;
	}

	public void setAuthors(List<DoubanUser> authors) {
		this.authors = authors;
	}

	public DoubanContentPhotos getPhotos() {
		return photos;
	}

	public void setPhotos(DoubanContentPhotos photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanNote [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", canReply=");
		builder.append(canReply);
		builder.append(", privacy=");
		builder.append(privacy);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", content=");
		builder.append(content);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", recommendedCount=");
		builder.append(recommendedCount);
		builder.append(", commentsCount=");
		builder.append(commentsCount);
		builder.append(", likedCount=");
		builder.append(likedCount);
		builder.append(", authors=");
		builder.append(authors);
		builder.append(", photos=");
		builder.append(photos);
		builder.append("]");
		return builder.toString();
	}

}
