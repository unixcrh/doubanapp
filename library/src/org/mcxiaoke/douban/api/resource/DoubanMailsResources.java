/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanMail;
import org.mcxiaoke.douban.api.model.DoubanMails;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMailsResources {

	DoubanResponse<DoubanMail> getMail(long mailId, boolean keepUnRead);

	DoubanResponse<Boolean> deleteMail(long mailId);

	DoubanResponse<Boolean> deleteMails(String mailIds);

	DoubanResponse<Boolean> markMail(long mailId);

	DoubanResponse<Boolean> markMails(String mailIds);

	DoubanResponse<DoubanMails> getMailsInbox();

	DoubanResponse<DoubanMails> getMailsOutbox();

	DoubanResponse<DoubanMails> getMailsUnRead();

	DoubanResponse<DoubanMail> sendMail(String title, String content,
			long receiverId);

	DoubanResponse<DoubanMail> sendMail(String title, String content,
			long receiverId, String captchaToken, String captcha);

}
