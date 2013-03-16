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
public class DoubanBookItem extends AbstractModel {
	@JsonProperty("status")
	private String status;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("updated")
	private Date updatedAt;
	@JsonProperty("book")
	private DoubanBook book;
	@JsonProperty("user_id")
	private long userId;
	@JsonProperty("book_id")
	private long bookId;
	@JsonProperty("tags")
	private List<String> tags;
	@JsonProperty("id")
	private long id;
	@JsonProperty("comment")
	private String comment;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public DoubanBook getBook() {
		return book;
	}

	public void setBook(DoubanBook book) {
		this.book = book;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanBooksCollectionItem [status=");
		builder.append(status);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", book=");
		builder.append(book);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", bookId=");
		builder.append(bookId);
		builder.append(", tags=");
		builder.append(tags);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
