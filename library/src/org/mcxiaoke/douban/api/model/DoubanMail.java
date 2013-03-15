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
public class DoubanMail extends AbstractModel {
	public static enum Status {
		READ, UNREAD;
	}

	@JsonProperty("id")
	private long id;
	@JsonProperty("status")
	private String status;
	@JsonProperty("title")
	private String title;
	@JsonProperty("published")
	private Date published;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
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

}
