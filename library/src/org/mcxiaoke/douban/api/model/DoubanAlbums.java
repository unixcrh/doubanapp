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
public class DoubanAlbums extends AbstractListModel<DoubanAlbum> {
	@JsonProperty("albums")
	private List<DoubanAlbum> albums;
	@JsonProperty("user")
	private DoubanUser user;

	public List<DoubanAlbum> getAlbums() {
		return albums;
	}

	public void setAlbums(List<DoubanAlbum> albums) {
		this.albums = albums;
	}

	@Override
	public List<DoubanAlbum> getData() {
		return albums;
	}

	@Override
	public int size() {
		return albums == null ? NULL_SIZE : albums.size();
	}

	@Override
	public String toString() {
		final int maxLen = 5;
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanAlbums [albums=");
		builder.append(albums != null ? albums.subList(0,
				Math.min(albums.size(), maxLen)) : null);
		builder.append(", user=");
		builder.append(user);
		builder.append(", getCount()=");
		builder.append(getCount());
		builder.append(", getStart()=");
		builder.append(getStart());
		builder.append(", getTotal()=");
		builder.append(getTotal());
		builder.append("]");
		return builder.toString();
	}

}
