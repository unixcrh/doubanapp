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
public class DoubanBookReview extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("author")
	private DoubanUser author;
	@JsonProperty("book")
	private DoubanBook book;
	@JsonProperty("rating")
	private DoubanRate rate;
	@JsonProperty("votes")
	private int votes;
	@JsonProperty("useless")
	private int useless;
	@JsonProperty("comments")
	private int comments;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("published")
	private Date createdAt;
	@JsonProperty("updated")
	private Date updatedAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public DoubanUser getAuthor() {
		return author;
	}

	public void setAuthor(DoubanUser author) {
		this.author = author;
	}

	public DoubanBook getBook() {
		return book;
	}

	public void setBook(DoubanBook book) {
		this.book = book;
	}

	public DoubanRate getRate() {
		return rate;
	}

	public void setRate(DoubanRate rate) {
		this.rate = rate;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getUseless() {
		return useless;
	}

	public void setUseless(int useless) {
		this.useless = useless;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanBookReview [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", author=");
		builder.append(author);
		builder.append(", book=");
		builder.append(book);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", votes=");
		builder.append(votes);
		builder.append(", useless=");
		builder.append(useless);
		builder.append(", comments=");
		builder.append(comments);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}

}
