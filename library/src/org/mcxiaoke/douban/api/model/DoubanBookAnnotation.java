/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import org.mcxiaoke.douban.api.parser.DoubanDateDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanBookAnnotation extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("book_id")
	private long bookId;
	@JsonProperty("book")
	private DoubanBook book;
	@JsonProperty("author_id")
	private long authorId;
	@JsonProperty("author_user")
	private DoubanUser author;
	@JsonProperty("chapter")
	private String chapter;
	@JsonProperty("page_no")
	private int pageNo;
	@JsonProperty("privacy")
	private int privacy;
	@JsonProperty("abstract")
	private String abstractText;
	@JsonProperty("abstract_photo")
	private String abstractPhoto;
	@JsonProperty("content")
	private String content;
	@JsonProperty("photos")
	private DoubanContentPhotos photos;
	@JsonProperty("last_photo")
	private int lastPhotoId;
	@JsonProperty("comments_count")
	private int commentsCount;
	@JsonProperty("hasmath")
	private boolean hasMath;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("time")
	private Date createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public DoubanBook getBook() {
		return book;
	}

	public void setBook(DoubanBook book) {
		this.book = book;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public DoubanUser getAuthor() {
		return author;
	}

	public void setAuthor(DoubanUser author) {
		this.author = author;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPrivacy() {
		return privacy;
	}

	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}

	public String getAbstractText() {
		return abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	public String getAbstractPhoto() {
		return abstractPhoto;
	}

	public void setAbstractPhoto(String abstractPhoto) {
		this.abstractPhoto = abstractPhoto;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public DoubanContentPhotos getPhotos() {
		return photos;
	}

	public void setPhotos(DoubanContentPhotos photos) {
		this.photos = photos;
	}

	public int getLastPhotoId() {
		return lastPhotoId;
	}

	public void setLastPhotoId(int lastPhotoId) {
		this.lastPhotoId = lastPhotoId;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public boolean isHasMath() {
		return hasMath;
	}

	public void setHasMath(boolean hasMath) {
		this.hasMath = hasMath;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanBookAnnotation [id=");
		builder.append(id);
		builder.append(", bookId=");
		builder.append(bookId);
		builder.append(", book=");
		builder.append(book);
		builder.append(", authorId=");
		builder.append(authorId);
		builder.append(", author=");
		builder.append(author);
		builder.append(", chapter=");
		builder.append(chapter);
		builder.append(", pageNo=");
		builder.append(pageNo);
		builder.append(", privacy=");
		builder.append(privacy);
		builder.append(", abstractText=");
		builder.append(abstractText);
		builder.append(", abstractPhoto=");
		builder.append(abstractPhoto);
		builder.append(", content=");
		builder.append(content);
		builder.append(", photos=");
		builder.append(photos);
		builder.append(", lastPhotoId=");
		builder.append(lastPhotoId);
		builder.append(", commentsCount=");
		builder.append(commentsCount);
		builder.append(", hasMath=");
		builder.append(hasMath);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append("]");
		return builder.toString();
	}

}
