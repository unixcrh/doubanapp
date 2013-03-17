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
public class DoubanMusic extends AbstractModel {
	@JsonProperty("rating")
	private DoubanRate rate;
	@JsonProperty("author")
	private List<String> authors;
	@JsonProperty("alt_title")
	private String altTitle;
	@JsonProperty("image")
	private String image;
	@JsonProperty("title")
	private String title;
	@JsonProperty("mobile_link")
	private String mobileUrl;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("attrs")
	private DoubanAttribute attrs;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("id")
	private long id;
	@JsonProperty("tags")
	private List<DoubanTag> tags;

	public DoubanRate getRate() {
		return rate;
	}

	public void setRate(DoubanRate rate) {
		this.rate = rate;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getAltTitle() {
		return altTitle;
	}

	public void setAltTitle(String altTitle) {
		this.altTitle = altTitle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobileUrl() {
		return mobileUrl;
	}

	public void setMobileUrl(String mobileUrl) {
		this.mobileUrl = mobileUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public DoubanAttribute getAttrs() {
		return attrs;
	}

	public void setAttrs(DoubanAttribute attrs) {
		this.attrs = attrs;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<DoubanTag> getTags() {
		return tags;
	}

	public void setTags(List<DoubanTag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanMusic [rate=");
		builder.append(rate);
		builder.append(", authors=");
		builder.append(authors);
		builder.append(", altTitle=");
		builder.append(altTitle);
		builder.append(", image=");
		builder.append(image);
		builder.append(", title=");
		builder.append(title);
		builder.append(", mobileUrl=");
		builder.append(mobileUrl);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", attrs=");
		builder.append(attrs);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", id=");
		builder.append(id);
		builder.append(", tags=");
		builder.append(tags);
		builder.append("]");
		return builder.toString();
	}

}
