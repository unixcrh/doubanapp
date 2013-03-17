/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanBooks extends AbstractListModel {
	private List<DoubanBook> books;

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

}
