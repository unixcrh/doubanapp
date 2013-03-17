/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import org.mcxiaoke.douban.api.parser.DoubanDateDeserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 豆瓣用户对象Model类
 * 
 * @author mcxiaoke
 * 
 */
public class DoubanUser extends AbstractModel {
	@JsonProperty("id")
	private long id;
	@JsonProperty("uid")
	private String uid;
	@JsonProperty("name")
	private String name;
	@JsonProperty("type")
	private String type;
	@JsonProperty("signature")
	private String signature;
	@JsonProperty("avatar")
	private String avatar;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("relation")
	private String relation;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("created")
	private Date created;
	@JsonProperty("loc_id")
	private int locId;
	@JsonProperty("loc_name")
	private String locName;
	@JsonProperty("desc")
	private String desc;

	// below is from doubanshuo api
	@JsonProperty("following_count")
	private int followingCount;
	@JsonProperty("followers_count")
	private int followersCount;
	@JsonProperty("statuses_count")
	private int statusesCount;
	@JsonProperty("logged_in")
	private boolean loggedIn;
	@JsonProperty("following")
	private boolean following;
	@JsonProperty("blocked")
	private boolean blocked;
	@JsonProperty("blocking")
	private boolean blocking;
	@JsonProperty("city")
	private String city;
	@JsonProperty("verified")
	private boolean verified;
	@JsonProperty("is_first_visit")
	private boolean isFirstVisit;
	@JsonProperty("lcoation")
	private String location;
	@JsonProperty("screen_name")
	private String screenName;
	@JsonProperty("description")
	private String description;
	@JsonProperty("url")
	private String url;
	@JsonProperty("large_avatar")
	private String largeAvatar;
	@JsonProperty("icon_avatar")
	private String iconAvatar;
	@JsonProperty("small_avatar")
	private String smallAvatar;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("created_at")
	private Date createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isFollowing() {
		return following;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isBlocking() {
		return blocking;
	}

	public void setBlocking(boolean blocking) {
		this.blocking = blocking;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isFirstVisit() {
		return isFirstVisit;
	}

	public void setFirstVisit(boolean isFirstVisit) {
		this.isFirstVisit = isFirstVisit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLargeAvatar() {
		return largeAvatar;
	}

	public void setLargeAvatar(String largeAvatar) {
		this.largeAvatar = largeAvatar;
	}

	public String getIconAvatar() {
		return iconAvatar;
	}

	public void setIconAvatar(String iconAvatar) {
		this.iconAvatar = iconAvatar;
	}

	public String getSmallAvatar() {
		return smallAvatar;
	}

	public void setSmallAvatar(String smallAvatar) {
		this.smallAvatar = smallAvatar;
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
		builder.append("DoubanUser [id=");
		builder.append(id);
		builder.append(", uid=");
		builder.append(uid);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", signature=");
		builder.append(signature);
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", relation=");
		builder.append(relation);
		builder.append(", created=");
		builder.append(created);
		builder.append(", locId=");
		builder.append(locId);
		builder.append(", locName=");
		builder.append(locName);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", followingCount=");
		builder.append(followingCount);
		builder.append(", followersCount=");
		builder.append(followersCount);
		builder.append(", statusesCount=");
		builder.append(statusesCount);
		builder.append(", loggedIn=");
		builder.append(loggedIn);
		builder.append(", following=");
		builder.append(following);
		builder.append(", blocked=");
		builder.append(blocked);
		builder.append(", blocking=");
		builder.append(blocking);
		builder.append(", city=");
		builder.append(city);
		builder.append(", verified=");
		builder.append(verified);
		builder.append(", isFirstVisit=");
		builder.append(isFirstVisit);
		builder.append(", location=");
		builder.append(location);
		builder.append(", screenName=");
		builder.append(screenName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", url=");
		builder.append(url);
		builder.append(", largeAvatar=");
		builder.append(largeAvatar);
		builder.append(", iconAvatar=");
		builder.append(iconAvatar);
		builder.append(", smallAvatar=");
		builder.append(smallAvatar);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append("]");
		return builder.toString();
	}

}
