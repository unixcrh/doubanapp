/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.ArrayList;
import java.util.Collections;

import android.text.TextUtils;
import android.util.Log;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanNotePhotos extends AbstractModel {
	private ArrayList<Integer> ids = new ArrayList<Integer>();
	private ArrayList<String> urls = new ArrayList<String>();

	public void add(int id, String url) {
		ids.add(id);
		urls.add(url);
	}

	public void sort() {
		Collections.sort(ids);
		Collections.sort(urls);
	}

	public ArrayList<Integer> getIds() {
		return ids;
	}

	public void setIds(ArrayList<Integer> ids) {
		this.ids = ids;
	}

	public ArrayList<String> getUrls() {
		return urls;
	}

	public void setUrls(ArrayList<String> urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanNotePhotos [ids=");
		builder.append(ids);
		builder.append(", urls=");
		builder.append(urls);
		builder.append("]");
		return builder.toString();
	}

}
