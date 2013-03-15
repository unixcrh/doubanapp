/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;
import java.util.List;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanOnline extends AbstractModel {
	private boolean liked;
	private long albumId;
	private String image;
	private int recsCount;
	private DoubanUser owner;
	private String alt;
	private long id;
	private String thumb;
	private String title;
	private List<String> tags;
	private String relatedUrl;
	private int likedCount;
	private boolean cascadeInvite;
	private String desc;
	private boolean participated;
	private String shuoTopic;
	private Date beginTime;
	private Date endTime;
	private String icon;
	private String cover;
	private Date created;
	private int groupId;
	private int photoCount;

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

	public int getRecsCount() {
		return recsCount;
	}

	public void setRecsCount(int recsCount) {
		this.recsCount = recsCount;
	}

	public DoubanUser getOwner() {
		return owner;
	}

	public void setOwner(DoubanUser owner) {
		this.owner = owner;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isParticipated() {
		return participated;
	}

	public void setParticipated(boolean participated) {
		this.participated = participated;
	}

	public String getShuoTopic() {
		return shuoTopic;
	}

	public void setShuoTopic(String shuoTopic) {
		this.shuoTopic = shuoTopic;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(int photoCount) {
		this.photoCount = photoCount;
	}
}
