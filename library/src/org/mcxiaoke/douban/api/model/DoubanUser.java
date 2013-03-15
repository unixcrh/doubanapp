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
	@JsonProperty("screen_name")
	private String sceenName;
	@JsonProperty("signature")
	private String signature;
	@JsonProperty("avatar")
	private String avatar;
	@JsonProperty("small_avatar")
	private String smallAvatar;
	@JsonProperty("large_avatar")
	private String largeAvatar;
	@JsonProperty("alt")
	private String webUrl;
	@JsonProperty("relation")
	private String relation;
	@JsonDeserialize(using = DoubanDateDeserializer.class)
	@JsonProperty("created")
	private Date createdAt;
	@JsonProperty("loc_id")
	private int locId;
	@JsonProperty("loc_name")
	private String locName;
	@JsonProperty("desc")
	private String description;

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

	public String getSceenName() {
		return sceenName;
	}

	public void setSceenName(String sceenName) {
		this.sceenName = sceenName;
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

	public String getSmallAvatar() {
		return smallAvatar;
	}

	public void setSmallAvatar(String smallAvatar) {
		this.smallAvatar = smallAvatar;
	}

	public String getLargeAvatar() {
		return largeAvatar;
	}

	public void setLargeAvatar(String largeAvatar) {
		this.largeAvatar = largeAvatar;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append(", smallAvatar=");
		builder.append(smallAvatar);
		builder.append(", largeAvatar=");
		builder.append(largeAvatar);
		builder.append(", webUrl=");
		builder.append(webUrl);
		builder.append(", relation=");
		builder.append(relation);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", locId=");
		builder.append(locId);
		builder.append(", locName=");
		builder.append(locName);
		builder.append(", desc=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
