/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanMusics extends AbstractListModel<DoubanMusic> {
	private List<DoubanMusic> musics;

	public List<DoubanMusic> getMusics() {
		return musics;
	}

	public void setMusics(List<DoubanMusic> musics) {
		this.musics = musics;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanMusics [musics=");
		builder.append(musics);
		builder.append(", getCount()=");
		builder.append(getCount());
		builder.append(", getStart()=");
		builder.append(getStart());
		builder.append(", getTotal()=");
		builder.append(getTotal());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<DoubanMusic> getData() {
		return musics;
	}

	@Override
	public int size() {
		return musics == null ? NULL_SIZE : musics.size();
	}

}
