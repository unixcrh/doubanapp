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
public class DoubanBook extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("publisher")
	private String publisher;
	@JsonProperty("title")
	private String title;
	@JsonProperty("sub_title")
	private String subTitle;
	@JsonProperty("original_title")
	private String originalTitle;
	@JsonProperty("alt_title")
	private String altTitle;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("author_intro")
	private String authorIntroduction;
	@JsonProperty("pubdate")
	private String publishDate;
	@JsonProperty("isbn10")
	private String isbn10;
	@JsonProperty("isbn13")
	private String isbn13;
	@JsonProperty("binding")
	private String binding;
	@JsonProperty("url")
	private String url;
	@JsonProperty("image")
	private String image;
	@JsonProperty("price")
	private String price;
	@JsonProperty("pages")
	private String pages;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("author")
	private List<String> authors;
	@JsonProperty("translator")
	private List<String> translators;
	@JsonProperty("tags")
	private List<DoubanTag> tags;
	@JsonProperty("rating")
	private DoubanRate rate;
	@JsonProperty("images")
	private DoubanImage images;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getAltTitle() {
		return altTitle;
	}

	public void setAltTitle(String altTitle) {
		this.altTitle = altTitle;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getAuthorIntroduction() {
		return authorIntroduction;
	}

	public void setAuthorIntroduction(String authorIntroduction) {
		this.authorIntroduction = authorIntroduction;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public List<String> getTranslators() {
		return translators;
	}

	public void setTranslators(List<String> translators) {
		this.translators = translators;
	}

	public List<DoubanTag> getTags() {
		return tags;
	}

	public void setTags(List<DoubanTag> tags) {
		this.tags = tags;
	}

	public DoubanRate getRate() {
		return rate;
	}

	public void setRate(DoubanRate rate) {
		this.rate = rate;
	}

	public DoubanImage getImages() {
		return images;
	}

	public void setImages(DoubanImage images) {
		this.images = images;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanBook [id=");
		builder.append(id);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", title=");
		builder.append(title);
		builder.append(", subTitle=");
		builder.append(subTitle);
		builder.append(", originalTitle=");
		builder.append(originalTitle);
		builder.append(", altTitle=");
		builder.append(altTitle);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", authorIntroduction=");
		builder.append(authorIntroduction);
		builder.append(", publishDate=");
		builder.append(publishDate);
		builder.append(", isbn10=");
		builder.append(isbn10);
		builder.append(", isbn13=");
		builder.append(isbn13);
		builder.append(", binding=");
		builder.append(binding);
		builder.append(", url=");
		builder.append(url);
		builder.append(", image=");
		builder.append(image);
		builder.append(", price=");
		builder.append(price);
		builder.append(", pages=");
		builder.append(pages);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", authors=");
		builder.append(authors);
		builder.append(", translators=");
		builder.append(translators);
		builder.append(", tags=");
		builder.append(tags);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", images=");
		builder.append(images);
		builder.append("]");
		return builder.toString();
	}

}
