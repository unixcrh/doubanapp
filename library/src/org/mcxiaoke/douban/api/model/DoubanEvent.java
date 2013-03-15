/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;

import org.mcxiaoke.douban.api.parser.DateDeserializer;

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
	private String adaptUrl;
	@JsonProperty("participant_count")
	private int participantCount;
	@JsonProperty("image")
	private String image;
	@JsonProperty("image_hlarge")
	private String imageLarge;
	@JsonProperty("image_hmobile")
	private String imageMobile;
	@JsonProperty("loc_name")
	private String locName;
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonProperty("begin_time")
	private Date beginTime;
	@JsonProperty("owner")
	private DoubanUser owner;
	@JsonProperty("alt")
	private String alt;
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
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonProperty("end_time")
	private Date endTime;
	@JsonProperty("is_pri")
	private boolean isPrivate;
	@JsonProperty("can_invite")
	private boolean canInvite;
	@JsonProperty("address")
	private String address;
	@JsonProperty("has_invite")
	private boolean hasInvited;

}
