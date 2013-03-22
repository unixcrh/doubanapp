/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.api.model.DoubanMail;
import org.mcxiaoke.douban.api.model.DoubanMails;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMailsResources {

	DoubanMail getMail(long mailId, boolean keepUnRead);

	boolean deleteMail(long mailId);

	boolean deleteMails(String mailIds);

	DoubanMail markMail(long mailId);

	DoubanMails markMails(String mailIds);

	DoubanMails getMailsInbox();

	DoubanMails getMailsOutbox();

	DoubanMails getMailsUnRead();

	boolean sendMail(String title, String content, long receiverId);

	boolean sendMail(String title, String content, long receiverId,
			String captchaToken, String captcha);

}
