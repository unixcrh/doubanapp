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
	private DoubanRate rating;
	@JsonProperty("author")
	private List<String> author;
	@JsonProperty("alt_title")
	private String altTitle;
	@JsonProperty("image")
	private String image;
	@JsonProperty("title")
	private String title;
	@JsonProperty("mobile_link")
	private String mobileLink;
	@JsonProperty("summary")
	private String summary;
	@JsonProperty("publisher")
	private String publisher;
	@JsonProperty("singer")
	private String singer;
	@JsonProperty("version")
	private String version;
	@JsonProperty("pubdate")
	private String pubdate;
	@JsonProperty("media")
	private String media;
	@JsonProperty("tracks")
	private List<String> tracks;
	@JsonProperty("discs")
	private int discs;
	@JsonProperty("alt")
	private String alt;
	@JsonProperty("id")
	private long id;
	@JsonProperty("tags")
	private List<DoubanTag> tags;

	public DoubanRate getRating() {
		return rating;
	}

	public void setRating(DoubanRate rating) {
		this.rating = rating;
	}

	public List<String> getAuthor() {
		return author;
	}

	public void setAuthor(List<String> author) {
		this.author = author;
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

	public String getMobileLink() {
		return mobileLink;
	}

	public void setMobileLink(String mobileLink) {
		this.mobileLink = mobileLink;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public int getDiscs() {
		return discs;
	}

	public void setDiscs(int discs) {
		this.discs = discs;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
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

}
