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
public class DoubanMails extends AbstractListModel<DoubanMail> {
	@JsonProperty("mails")
	private List<DoubanMail> mails;

	public List<DoubanMail> getMails() {
		return mails;
	}

	public void setMails(List<DoubanMail> mails) {
		this.mails = mails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanMails [mails=");
		builder.append(mails);
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
	public List<DoubanMail> getData() {
		return mails;
	}

	@Override
	public int size() {
		return mails == null ? NULL_SIZE : mails.size();
	}

}
