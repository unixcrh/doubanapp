/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanMail extends AbstractModel {
	public static enum Status {
		READ, UNREAD;
	}

	private long id;
	private String status;
	private String title;
	private Date published;
	private String content;
	private DoubanUser sender;
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
