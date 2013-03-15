/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import org.mcxiaoke.douban.api.parser.DateDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 豆瓣用户对象Model类
 * 
 * @author mcxiaoke
 * 
 */
public class DoubanUser extends AbstractModel {
	private long id;
	private String uid;
	private String name;
	private String avatar;
	private String smallAvatar;
	private String largeAvatar;
	private String alt;
	private String relation;
	@JsonDeserialize(using = DateDeserializer.class)
	private Date created;
	private int locId;
	private String locName;
	private String desc;

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

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
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

}
