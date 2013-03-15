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
public class DoubanShuoEntity extends AbstractModel {
	@JsonProperty("user_mentions")
	private List<DoubanShuoEntityUser> users;
	@JsonProperty("topics")
	private List<DoubanShuoEntityTopic> topics;
	@JsonProperty("urls")
	private List<DoubanShuoEntityUrl> urls;

	public List<DoubanShuoEntityUser> getUsers() {
		return users;
	}

	public void setUsers(List<DoubanShuoEntityUser> users) {
		this.users = users;
	}

	public List<DoubanShuoEntityTopic> getTopics() {
		return topics;
	}

	public void setTopics(List<DoubanShuoEntityTopic> topics) {
		this.topics = topics;
	}

	public List<DoubanShuoEntityUrl> getUrls() {
		return urls;
	}

	public void setUrls(List<DoubanShuoEntityUrl> urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanShuoEntity [users=");
		builder.append(users);
		builder.append(", topics=");
		builder.append(topics);
		builder.append(", urls=");
		builder.append(urls);
		builder.append("]");
		return builder.toString();
	}

}
