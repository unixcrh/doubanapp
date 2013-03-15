/**
 * 
 */
package org.mcxiaoke.douban.api.model;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanShuoMedia extends AbstractModel {
	private String src;
	private String secretPid;
	private String originalSrc;
	private String href;
	private String type;
	private String imgsrc;
	private String title;
	private String artist;
	private String album;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSecretPid() {
		return secretPid;
	}

	public void setSecretPid(String secretPid) {
		this.secretPid = secretPid;
	}

	public String getOriginalSrc() {
		return originalSrc;
	}

	public void setOriginalSrc(String originalSrc) {
		this.originalSrc = originalSrc;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

}
