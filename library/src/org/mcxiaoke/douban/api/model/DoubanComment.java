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
public class DoubanComment extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("created")
	private Date created;
	@JsonProperty("content")
	private String content;
	@JsonProperty("author")
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
