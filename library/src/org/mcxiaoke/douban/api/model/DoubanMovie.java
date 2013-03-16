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
public class DoubanMovie extends AbstractModel {
	@JsonProperty("rating")
	private DoubanRate rate;
	@JsonProperty("reviews_count")
	private int reviewsCount;
	@JsonProperty("wish_count")
	private int wishCount;
	@JsonProperty("collect_count")
	private int collectCount;
	@JsonProperty("comments_count")
	private int commentsCount;
	@JsonProperty("ratings_count")
	private int ratingsCount;
	@JsonProperty("douban_site")
	private String doubanSite;
	@JsonProperty("year")
	private int year;
	@JsonProperty("images")
	private DoubanImage images;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("id")
	private long id;
	@JsonProperty("mobie_url")
	private String mobileUrl;
	@JsonProperty("title")
	private String title;
	@JsonProperty("original_title")
	private String originalTitle;
	@JsonProperty("summay")
	private String summary;
	@JsonProperty("subtype")
	private String subType;
	@JsonProperty("do_count")
	private int doCount;
	@JsonProperty("seasons_count")
	private int seasonsCount;
	@JsonProperty("current_season")
	private int currentSeason;
	@JsonProperty("episodes_count")
	private int episodesCount;
	@JsonProperty("schedule_url")
	private String scheduleUrl;
	@JsonProperty("genres")
	private List<String> genres;
	@JsonProperty("countries")
	private List<String> countries;
	@JsonProperty("aka")
	private List<String> aka;
	@JsonProperty("casts")
	private List<DoubanAuthor> casts;
	@JsonProperty("directors")
	private List<DoubanAuthor> directors;
	@JsonProperty("writers")
	private List<DoubanAuthor> writers;
	@JsonProperty("website")
	private String website;
	@JsonProperty("languages")
	private List<String> languages;
	@JsonProperty("durations")
	private int durations;
	@JsonProperty("pubdates")
	private String publishedAt;
	@JsonProperty("mainland_pubdates")
	private String mainlandPublishedAt;
	@JsonProperty("pubdate")
	private String publishedDate;

	public DoubanRate getRate() {
		return rate;
	}

	public void setRate(DoubanRate rate) {
		this.rate = rate;
	}

	public int getReviewsCount() {
		return reviewsCount;
	}

	public void setReviewsCount(int reviewsCount) {
		this.reviewsCount = reviewsCount;
	}

	public int getWishCount() {
		return wishCount;
	}

	public void setWishCount(int wishCount) {
		this.wishCount = wishCount;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public int getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public String getDoubanSite() {
		return doubanSite;
	}

	public void setDoubanSite(String doubanSite) {
		this.doubanSite = doubanSite;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public DoubanImage getImages() {
		return images;
	}

	public void setImages(DoubanImage images) {
		this.images = images;
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

	public String getMobileUrl() {
		return mobileUrl;
	}

	public void setMobileUrl(String mobileUrl) {
		this.mobileUrl = mobileUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public int getDoCount() {
		return doCount;
	}

	public void setDoCount(int doCount) {
		this.doCount = doCount;
	}

	public int getSeasonsCount() {
		return seasonsCount;
	}

	public void setSeasonsCount(int seasonsCount) {
		this.seasonsCount = seasonsCount;
	}

	public int getCurrentSeason() {
		return currentSeason;
	}

	public void setCurrentSeason(int currentSeason) {
		this.currentSeason = currentSeason;
	}

	public int getEpisodesCount() {
		return episodesCount;
	}

	public void setEpisodesCount(int episodesCount) {
		this.episodesCount = episodesCount;
	}

	public String getScheduleUrl() {
		return scheduleUrl;
	}

	public void setScheduleUrl(String scheduleUrl) {
		this.scheduleUrl = scheduleUrl;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<String> getAka() {
		return aka;
	}

	public void setAka(List<String> aka) {
		this.aka = aka;
	}

	public List<DoubanAuthor> getCasts() {
		return casts;
	}

	public void setCasts(List<DoubanAuthor> casts) {
		this.casts = casts;
	}

	public List<DoubanAuthor> getDirectors() {
		return directors;
	}

	public void setDirectors(List<DoubanAuthor> directors) {
		this.directors = directors;
	}

	public List<DoubanAuthor> getWriters() {
		return writers;
	}

	public void setWriters(List<DoubanAuthor> writers) {
		this.writers = writers;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public int getDurations() {
		return durations;
	}

	public void setDurations(int durations) {
		this.durations = durations;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getMainlandPublishedAt() {
		return mainlandPublishedAt;
	}

	public void setMainlandPublishedAt(String mainlandPublishedAt) {
		this.mainlandPublishedAt = mainlandPublishedAt;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanMovie [rate=");
		builder.append(rate);
		builder.append(", reviewsCount=");
		builder.append(reviewsCount);
		builder.append(", wishCount=");
		builder.append(wishCount);
		builder.append(", collectCount=");
		builder.append(collectCount);
		builder.append(", commentsCount=");
		builder.append(commentsCount);
		builder.append(", ratingsCount=");
		builder.append(ratingsCount);
		builder.append(", doubanSite=");
		builder.append(doubanSite);
		builder.append(", year=");
		builder.append(year);
		builder.append(", images=");
		builder.append(images);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", id=");
		builder.append(id);
		builder.append(", mobileUrl=");
		builder.append(mobileUrl);
		builder.append(", title=");
		builder.append(title);
		builder.append(", originalTitle=");
		builder.append(originalTitle);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", subType=");
		builder.append(subType);
		builder.append(", doCount=");
		builder.append(doCount);
		builder.append(", seasonsCount=");
		builder.append(seasonsCount);
		builder.append(", currentSeason=");
		builder.append(currentSeason);
		builder.append(", episodesCount=");
		builder.append(episodesCount);
		builder.append(", scheduleUrl=");
		builder.append(scheduleUrl);
		builder.append(", genres=");
		builder.append(genres);
		builder.append(", countries=");
		builder.append(countries);
		builder.append(", aka=");
		builder.append(aka);
		builder.append(", casts=");
		builder.append(casts);
		builder.append(", directors=");
		builder.append(directors);
		builder.append(", writers=");
		builder.append(writers);
		builder.append(", website=");
		builder.append(website);
		builder.append(", languages=");
		builder.append(languages);
		builder.append(", durations=");
		builder.append(durations);
		builder.append("]");
		return builder.toString();
	}

}
