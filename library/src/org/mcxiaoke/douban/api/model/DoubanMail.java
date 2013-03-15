/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import org.mcxiaoke.douban.api.parser.DoubanDateDeserializer;
import org.mcxiaoke.douban.api.parser.DoubanMailStatusDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanMail extends AbstractModel {

	@JsonProperty("id")
	private long id;
	@JsonDeserialize(using = DoubanMailStatusDeserializer.class)
	@JsonProperty("status")
	private boolean unread;
	@JsonProperty("title")
	private String title;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("published")
	private Date createdAt;
	@JsonProperty("content")
	private String content;
	@JsonProperty("sender")
	private DoubanUser sender;
	@JsonProperty("receiver")
	private DoubanUser receiver;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isUnread() {
		return unread;
	}

	public void setUnread(boolean unread) {
		this.unread = unread;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DoubanUser getSender() {
		return sender;
	}

	public void setSender(DoubanUser sender) {
		this.sender = sender;
	}

	public DoubanUser getReceiver() {
		return receiver;
	}

	public void setReceiver(DoubanUser receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanMail [id=");
		builder.append(id);
		builder.append(", unread=");
		builder.append(unread);
		builder.append(", title=");
		builder.append(title);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", content=");
		builder.append(content);
		builder.append(", sender=");
		builder.append(sender);
		builder.append(", receiver=");
		builder.append(receiver);
		builder.append("]");
		return builder.toString();
	}

}
