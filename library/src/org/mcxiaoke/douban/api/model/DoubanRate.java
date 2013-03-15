/**
 * 
 */
package org.mcxiaoke.douban.api.model;


/**
 * @author mcxiaoke
 * 
 */
public class DoubanRate extends AbstractModel {
	private int max;
	private int min;
	private int average;
	private int stars;
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
