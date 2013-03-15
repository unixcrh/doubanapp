/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.Date;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanEvent extends AbstractModel {
	private long album;
	private String adaptUrl;
	private int participantCount;
	private String image;
	private String imageLarge;
	private String imageMobile;
	private String locName;
	private Date beginTime;
	private DoubanUser owner;
	private String alt;
	private String geo;
	private long id;
	private String category;
	private int locId;
	private String title;
	private int wisherCount;
	private String content;
	private Date endTime;
	private boolean isPrivate;
	private boolean canInvite;
	private String address;
	private boolean hasInvited;

}
