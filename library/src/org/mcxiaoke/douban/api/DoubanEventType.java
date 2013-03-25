/**
 * 
 */
package org.mcxiaoke.douban.api;

/**
 * @author mcxiaoke
 *
 */
public enum DoubanEventType {
	
	MUSIC(10, "music","音乐"),
	DRAMA(11,"drama","戏剧"),
	EXHIBITION(12,"exhibition","展览"),
	SALON(13,"salon","讲座"),
	PARTY(14,"party","聚会"),
	SPORTS(15,"sports","运动"),
	TRAVEL(16,"travel","旅行"),
	COMMONWEAL(17,"commonweal","公益"),
	FILM(11,"film","电影"),
	;
	
	private int id;
	private String type;
	private String text;

	private DoubanEventType(int id, String type, String text) {
		this.id = id;
		this.type = type;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getText() {
		return text;
	}

}
