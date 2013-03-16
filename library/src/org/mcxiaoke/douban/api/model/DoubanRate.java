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
	private int maxRate;
	@JsonProperty("min")
	private int minRate;
	@JsonProperty("value")
	private double value;
	@JsonProperty("average")
	private double averageRate;
	@JsonProperty("stars")
	private int stars;
	@JsonProperty("numRaterss")
	private int ratersCount;

	public int getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(int maxRate) {
		this.maxRate = maxRate;
	}

	public int getMinRate() {
		return minRate;
	}

	public void setMinRate(int minRate) {
		this.minRate = minRate;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(double averageRate) {
		this.averageRate = averageRate;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getRatersCount() {
		return ratersCount;
	}

	public void setRatersCount(int ratersCount) {
		this.ratersCount = ratersCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanRate [maxRate=");
		builder.append(maxRate);
		builder.append(", minRate=");
		builder.append(minRate);
		builder.append(", value=");
		builder.append(value);
		builder.append(", averageRate=");
		builder.append(averageRate);
		builder.append(", stars=");
		builder.append(stars);
		builder.append(", ratersCount=");
		builder.append(ratersCount);
		builder.append("]");
		return builder.toString();
	}
}
