/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanShuo extends AbstractModel {
	@JsonProperty("status")
	private DoubanShuoStatus status;
	@JsonProperty("reshare_users")
	private List<DoubanUser> reshareUsers;
	@JsonProperty("like_users")
	private List<DoubanUser> likeUsers;
	@JsonProperty("comments")
	private List<DoubanComment> comments;

	public DoubanShuoStatus getStatus() {
		return status;
	}

	public void setStatus(DoubanShuoStatus status) {
		this.status = status;
	}

	public List<DoubanUser> getReshareUsers() {
		return reshareUsers;
	}

	public void setReshareUsers(List<DoubanUser> reshareUsers) {
		this.reshareUsers = reshareUsers;
	}

	public List<DoubanUser> getLikeUsers() {
		return likeUsers;
	}

	public void setLikeUsers(List<DoubanUser> likeUsers) {
		this.likeUsers = likeUsers;
	}

	public List<DoubanComment> getComments() {
		return comments;
	}

	public void setComments(List<DoubanComment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		final int maxLen = 5;
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanShuo [status=");
		builder.append(status);
		builder.append(", reshareUsers=");
		builder.append(reshareUsers != null ? reshareUsers.subList(0,
				Math.min(reshareUsers.size(), maxLen)) : null);
		builder.append(", likeUsers=");
		builder.append(likeUsers != null ? likeUsers.subList(0,
				Math.min(likeUsers.size(), maxLen)) : null);
		builder.append(", comments=");
		builder.append(comments != null ? comments.subList(0,
				Math.min(comments.size(), maxLen)) : null);
		builder.append("]");
		return builder.toString();
	}

}
