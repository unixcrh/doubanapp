/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import org.mcxiaoke.douban.api.parser.DoubanBooleanDeserializer;
import org.mcxiaoke.douban.api.parser.DoubanDateDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanEvent extends AbstractModel {
	@JsonProperty("album")
	private long album;
	@JsonProperty("adapt_url")
	private String eventUrl;
	@JsonProperty("participant_count")
	private int participantCount;
	@JsonProperty("image")
	private String image;
	@JsonProperty("image_hlarge")
	private String imageLarge;
	@JsonProperty("image_lmobile")
	private String imageMobile;
	@JsonProperty("loc_name")
	private String locName;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("begin_time")
	private Date beginTime;
	@JsonProperty("owner")
	private DoubanUser owner;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("geo")
	private String geo;
	@JsonProperty("id")
	private long id;
	@JsonProperty("category")
	private String category;
	@JsonProperty("loc_id")
	private int locId;
	@JsonProperty("title")
	private String title;
	@JsonProperty("wisher_count")
	private int wisherCount;
	@JsonProperty("content")
	private String content;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("end_time")
	private Date endTime;
	@JsonDeserialize(using = DoubanBooleanDeserializer.class)
	@JsonProperty("is_priv")
	private boolean isPrivate;
	@JsonDeserialize(using = DoubanBooleanDeserializer.class)
	@JsonProperty("can_invite")
	private boolean canInvite;
	@JsonProperty("address")
	private String address;
	@JsonDeserialize(using = DoubanBooleanDeserializer.class)
	@JsonProperty("has_invited")
	private boolean hasInvited;

	public long getAlbum() {
		return album;
	}

	public void setAlbum(long album) {
		this.album = album;
	}

	public String getEventUrl() {
		return eventUrl;
	}

	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

	public int getParticipantCount() {
		return participantCount;
	}

	public void setParticipantCount(int participantCount) {
		this.participantCount = participantCount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageLarge() {
		return imageLarge;
	}

	public void setImageLarge(String imageLarge) {
		this.imageLarge = imageLarge;
	}

	public String getImageMobile() {
		return imageMobile;
	}

	public void setImageMobile(String imageMobile) {
		this.imageMobile = imageMobile;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public DoubanUser getOwner() {
		return owner;
	}

	public void setOwner(DoubanUser owner) {
		this.owner = owner;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWisherCount() {
		return wisherCount;
	}

	public void setWisherCount(int wisherCount) {
		this.wisherCount = wisherCount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public boolean isCanInvite() {
		return canInvite;
	}

	public void setCanInvite(boolean canInvite) {
		this.canInvite = canInvite;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isHasInvited() {
		return hasInvited;
	}

	public void setHasInvited(boolean hasInvited) {
		this.hasInvited = hasInvited;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanEvent [album=");
		builder.append(album);
		builder.append(", eventUrl=");
		builder.append(eventUrl);
		builder.append(", participantCount=");
		builder.append(participantCount);
		builder.append(", image=");
		builder.append(image);
		builder.append(", imageLarge=");
		builder.append(imageLarge);
		builder.append(", imageMobile=");
		builder.append(imageMobile);
		builder.append(", locName=");
		builder.append(locName);
		builder.append(", beginTime=");
		builder.append(beginTime);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", geo=");
		builder.append(geo);
		builder.append(", id=");
		builder.append(id);
		builder.append(", category=");
		builder.append(category);
		builder.append(", locId=");
		builder.append(locId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", wisherCount=");
		builder.append(wisherCount);
		builder.append(", content=");
		builder.append(content);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", isPrivate=");
		builder.append(isPrivate);
		builder.append(", canInvite=");
		builder.append(canInvite);
		builder.append(", address=");
		builder.append(address);
		builder.append(", hasInvited=");
		builder.append(hasInvited);
		builder.append("]");
		return builder.toString();
	}

}
