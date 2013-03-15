/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanAlbumPhotos extends AbstractModel {
	private int count;
	private int start;
	private int total;
	private String order;
	private String sortBy;
	private DoubanAlbum album;
	private List<DoubanPhoto> photos;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

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
