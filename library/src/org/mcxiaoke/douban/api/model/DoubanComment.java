/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanComment extends AbstractModel {
	private long id;
	private Date created;
	private String content;
	private DoubanUser author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DoubanUser getAuthor() {
		return author;
	}

	public void setAuthor(DoubanUser author) {
		this.author = author;
	}

}
