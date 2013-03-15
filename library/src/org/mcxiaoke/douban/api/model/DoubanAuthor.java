/**
 * 
 */
package org.mcxiaoke.douban.api.model;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanAuthor extends AbstractModel {
	private long id;
	private String name;
	private String alt;
	private DoubanImage avatars;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public DoubanImage getAvatars() {
		return avatars;
	}

	public void setAvatars(DoubanImage avatars) {
		this.avatars = avatars;
	}

}
