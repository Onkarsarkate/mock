package com.example.test.Weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Daily {

	@JsonProperty("DailyForecasts")
	private DailyForecasts dailyForecasts;

	@Override
	public String toString() {
		return "Daily [dailyForecasts=" + dailyForecasts + "]";
	}

	public DailyForecasts getDailyForecasts() {
		return dailyForecasts;
	}

	public void setDailyForecasts(DailyForecasts dailyForecasts) {
		this.dailyForecasts = dailyForecasts;
	}

	

}
