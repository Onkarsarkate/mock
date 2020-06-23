package com.example.test.Weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {

	@JsonProperty("Minimum")
	private Minimum min;

	@Override
	public String toString() {
		return "Temperature [min=" + min + ", max=" + max + "]";
	}

	public Minimum getMin() {
		return min;
	}

	public void setMin(Minimum min) {
		this.min = min;
	}

	public Maximum getMax() {
		return max;
	}

	public void setMax(Maximum max) {
		this.max = max;
	}

	@JsonProperty("Maximum")

	private Maximum max;
}
