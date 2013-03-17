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
public class DoubanAttribute extends AbstractModel {
	@JsonProperty("publisher")
	private List<String> publishers;
	@JsonProperty("singer")
	private List<String> singers;
	@JsonProperty("version")
	private List<String> versions;
	@JsonProperty("pubdate")
	private List<String> publishDates;
	@JsonProperty("title")
	private List<String> titles;
	@JsonProperty("media")
	private List<String> medias;
	@JsonProperty("tracks")
	private List<String> tracks;
	@JsonProperty("discs")
	private List<String> discs;
	@JsonProperty("songs")
	private List<DoubanMusicTrack> songs;

	public List<String> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<String> publishers) {
		this.publishers = publishers;
	}

	public List<String> getSingers() {
		return singers;
	}

	public void setSingers(List<String> singers) {
		this.singers = singers;
	}

	public List<String> getVersions() {
		return versions;
	}

	public void setVersions(List<String> versions) {
		this.versions = versions;
	}

	public List<String> getPublishDates() {
		return publishDates;
	}

	public void setPublishDates(List<String> publishDates) {
		this.publishDates = publishDates;
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<String> getMedias() {
		return medias;
	}

	public void setMedias(List<String> medias) {
		this.medias = medias;
	}

	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public List<String> getDiscs() {
		return discs;
	}

	public void setDiscs(List<String> discs) {
		this.discs = discs;
	}

	public List<DoubanMusicTrack> getSongs() {
		return songs;
	}

	public void setSongs(List<DoubanMusicTrack> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanAttribute [publishers=");
		builder.append(publishers);
		builder.append(", singers=");
		builder.append(singers);
		builder.append(", versions=");
		builder.append(versions);
		builder.append(", publishDates=");
		builder.append(publishDates);
		builder.append(", titles=");
		builder.append(titles);
		builder.append(", medias=");
		builder.append(medias);
		builder.append(", tracks=");
		builder.append(tracks);
		builder.append(", discs=");
		builder.append(discs);
		builder.append(", songs=");
		builder.append(songs);
		builder.append("]");
		return builder.toString();
	}

}
