/**
 * 
 */
package org.mcxiaoke.douban.api.model;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanSource extends AbstractModel {
	private String href;
	private String title;
	private String name;
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
