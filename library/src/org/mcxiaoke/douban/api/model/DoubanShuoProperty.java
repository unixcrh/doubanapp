/**
 * 
 */
package org.mcxiaoke.douban.api.model;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanShuoProperty extends AbstractModel {
	private String href;
	private String uid;
	private String name;
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
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

}
