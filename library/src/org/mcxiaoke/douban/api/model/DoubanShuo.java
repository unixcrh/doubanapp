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
public class DoubanShuo extends AbstractModel {
	private long id;
	private String type;
	private String category;
	private String title;
	private String text;
	private Date createdAt;
	private boolean isFollow;
	private boolean hasPhoto;
	private boolean muted;
	private boolean canReply;
	private boolean liked;
	private int resharedCount;
	private int likeCount;
	private int commentsCount;

	private List<DoubanShuoAttachment> attachments;
	private List<DoubanShuoEntity> entities;
	private List<DoubanUser> users;
	private DoubanShuo resharedStatus;
	private DoubanSource source;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isFollow() {
		return isFollow;
	}

	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}

	public boolean isHasPhoto() {
		return hasPhoto;
	}

	public void setHasPhoto(boolean hasPhoto) {
		this.hasPhoto = hasPhoto;
	}

	public boolean isMuted() {
		return muted;
	}

	public void setMuted(boolean muted) {
		this.muted = muted;
	}

	public boolean isCanReply() {
		return canReply;
	}

	public void setCanReply(boolean canReply) {
		this.canReply = canReply;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public int getResharedCount() {
		return resharedCount;
	}

	public void setResharedCount(int resharedCount) {
		this.resharedCount = resharedCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public List<DoubanShuoAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<DoubanShuoAttachment> attachments) {
		this.attachments = attachments;
	}

	public List<DoubanShuoEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<DoubanShuoEntity> entities) {
		this.entities = entities;
	}

	public List<DoubanUser> getUsers() {
		return users;
	}

	public void setUsers(List<DoubanUser> users) {
		this.users = users;
	}

	public DoubanShuo getResharedStatus() {
		return resharedStatus;
	}

	public void setResharedStatus(DoubanShuo resharedStatus) {
		this.resharedStatus = resharedStatus;
	}

	public DoubanSource getSource() {
		return source;
	}

	public void setSource(DoubanSource source) {
		this.source = source;
	}

}
