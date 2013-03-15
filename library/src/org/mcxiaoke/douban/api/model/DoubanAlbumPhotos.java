/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanAlbumPhotos extends AbstractListModel {
	@JsonProperty("order")
	private String order;
	@JsonProperty("sortby")
	private String sortBy;
	@JsonProperty("album")
	private DoubanAlbum album;
	@JsonProperty("photos")
	private List<DoubanPhoto> photos;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public DoubanAlbum getAlbum() {
		return album;
	}

	public void setAlbum(DoubanAlbum album) {
		this.album = album;
	}

	public List<DoubanPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<DoubanPhoto> photos) {
		this.photos = photos;
	}

}
