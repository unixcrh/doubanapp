/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	private String alt;
	@JsonProperty("privacy")
	private String privacy;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("content")
	private String content;
	@JsonProperty("publish_time")
	private Date publishTime;
	@JsonProperty("udpate_time")
	private Date updateTime;
	@JsonProperty("resc_count")
	private int recsCount;
	@JsonProperty("comments_count")
	private int commentsCount;
	@JsonProperty("liked_count")
	private int likedCount;
	@JsonProperty("photos")
	private List<String> photos;

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

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
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

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getRecsCount() {
		return recsCount;
	}

	public void setRecsCount(int recsCount) {
		this.recsCount = recsCount;
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

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

}
