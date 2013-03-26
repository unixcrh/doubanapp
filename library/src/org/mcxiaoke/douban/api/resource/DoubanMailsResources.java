/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanMail;
import org.mcxiaoke.douban.api.model.DoubanMails;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanMailsResources {

	DoubanResponse<DoubanMail> getMail(long mailId, boolean keepUnRead) throws DoubanException, IOException;

	DoubanResponse<Boolean> deleteMail(long mailId) throws DoubanException, IOException;

	DoubanResponse<Boolean> deleteMails(String mailIds) throws DoubanException, IOException;

	DoubanResponse<Boolean> markMail(long mailId) throws DoubanException, IOException;

	DoubanResponse<Boolean> markMails(String mailIds) throws DoubanException, IOException;

	DoubanResponse<DoubanMails> getMailsInbox() throws DoubanException, IOException;

	DoubanResponse<DoubanMails> getMailsOutbox() throws DoubanException, IOException;

	DoubanResponse<DoubanMails> getMailsUnRead() throws DoubanException, IOException;

	DoubanResponse<DoubanMail> sendMail(String title, String content,
			long receiverId) throws DoubanException, IOException;

	DoubanResponse<DoubanMail> sendMail(String title, String content,
			long receiverId, String captchaToken, String captcha) throws DoubanException, IOException;

}
