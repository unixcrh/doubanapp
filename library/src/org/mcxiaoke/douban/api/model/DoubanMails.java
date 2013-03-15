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
public class DoubanMails extends AbstractListModel {
	@JsonProperty("mails")
	private List<DoubanMail> mails;

	public List<DoubanMail> getMails() {
		return mails;
	}

	public void setMails(List<DoubanMail> mails) {
		this.mails = mails;
	}

}
