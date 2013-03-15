/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanRate extends AbstractModel {
	@JsonProperty("max")
	private int max;
	@JsonProperty("min")
	private int min;
	@JsonProperty("average")
	private int average;
	@JsonProperty("stars")
	private int stars;
	@JsonProperty("numRaterss")
	private int numRaters;

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getNumRaters() {
		return numRaters;
	}

	public void setNumRaters(int numRaters) {
		this.numRaters = numRaters;
	}
}
