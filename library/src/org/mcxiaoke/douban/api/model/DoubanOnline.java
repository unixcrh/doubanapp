/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;
import java.util.List;

import org.mcxiaoke.douban.api.parser.DoubanDateDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanOnline extends AbstractModel {
	@JsonProperty("liked")
	private boolean liked;
	@JsonProperty("album_id")
	private long albumId;
	@JsonProperty("image")
	private String image;
	@JsonProperty("resc_count")
	private int recommendedCount;
	@JsonProperty("owner")
	private DoubanUser owner;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("id")
	private long id;
	@JsonProperty("thumb")
	private String thumb;
	@JsonProperty("title")
	private String title;
	@JsonProperty("tags")
	private List<String> tags;
	@JsonProperty("related_url")
	private String relatedUrl;
	@JsonProperty("liked_count")
	private int likedCount;
	@JsonProperty("cascade_invite")
	private boolean cascadeInvite;
	@JsonProperty("desc")
	private String description;
	@JsonProperty("participated")
	private boolean participated;
	@JsonProperty("shuo_topic")
	private String topic;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("begin_time")
	private Date beginAt;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("end_time")
	private Date endAt;
	@JsonProperty("icon")
	private String icon;
	@JsonProperty("cover")
	private String cover;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("created")
	private Date createdAt;
	@JsonProperty("group_id")
	private int groupId;
	@JsonProperty("photo_count")
	private int photosCount;
	@JsonProperty("participant_count")
	private int participantsCount;
	@JsonProperty("joined")
	private boolean joined;

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
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

	public DoubanUser getOwner() {
		return owner;
	}

	public void setOwner(DoubanUser owner) {
		this.owner = owner;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getRelatedUrl() {
		return relatedUrl;
	}

	public void setRelatedUrl(String relatedUrl) {
		this.relatedUrl = relatedUrl;
	}

	public int getLikedCount() {
		return likedCount;
	}

	public void setLikedCount(int likedCount) {
		this.likedCount = likedCount;
	}

	public boolean isCascadeInvite() {
		return cascadeInvite;
	}

	public void setCascadeInvite(boolean cascadeInvite) {
		this.cascadeInvite = cascadeInvite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isParticipated() {
		return participated;
	}

	public void setParticipated(boolean participated) {
		this.participated = participated;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getBeginAt() {
		return beginAt;
	}

	public void setBeginAt(Date beginAt) {
		this.beginAt = beginAt;
	}

	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getPhotosCount() {
		return photosCount;
	}

	public void setPhotosCount(int photosCount) {
		this.photosCount = photosCount;
	}

	public int getParticipantsCount() {
		return participantsCount;
	}

	public void setParticipantsCount(int participantsCount) {
		this.participantsCount = participantsCount;
	}

	public boolean isJoined() {
		return joined;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanOnline [liked=");
		builder.append(liked);
		builder.append(", albumId=");
		builder.append(albumId);
		builder.append(", image=");
		builder.append(image);
		builder.append(", recommendedCount=");
		builder.append(recommendedCount);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", id=");
		builder.append(id);
		builder.append(", thumb=");
		builder.append(thumb);
		builder.append(", title=");
		builder.append(title);
		builder.append(", tags=");
		builder.append(tags);
		builder.append(", relatedUrl=");
		builder.append(relatedUrl);
		builder.append(", likedCount=");
		builder.append(likedCount);
		builder.append(", cascadeInvite=");
		builder.append(cascadeInvite);
		builder.append(", description=");
		builder.append(description);
		builder.append(", participated=");
		builder.append(participated);
		builder.append(", topic=");
		builder.append(topic);
		builder.append(", beginAt=");
		builder.append(beginAt);
		builder.append(", endAt=");
		builder.append(endAt);
		builder.append(", icon=");
		builder.append(icon);
		builder.append(", cover=");
		builder.append(cover);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append(", photosCount=");
		builder.append(photosCount);
		builder.append(", participantsCount=");
		builder.append(participantsCount);
		builder.append(", joined=");
		builder.append(joined);
		builder.append("]");
		return builder.toString();
	}
}
