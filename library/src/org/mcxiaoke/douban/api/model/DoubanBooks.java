/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanBooks extends AbstractListModel<DoubanBook> {
	private List<DoubanBook> books;

	public DoubanBooks() {
		this(null);
	}

	public DoubanBooks(List<DoubanBook> data) {
		this.books = new ArrayList<DoubanBook>();
		if (data != null) {
			this.books.addAll(data);
		}
	}

	public List<DoubanBook> getBooks() {
		return books;
	}

	public void setBooks(List<DoubanBook> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanBooks [books=");
		builder.append(books);
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
	public List<DoubanBook> getData() {
		return books;
	}

	@Override
	public int size() {
		return books == null ? NULL_SIZE : books.size();
	}

}
