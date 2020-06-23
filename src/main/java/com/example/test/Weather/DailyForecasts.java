package com.example.test.Weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyForecasts {
	@JsonProperty("Date")
private String Date;
	@JsonProperty("Temperature")
	private Temperature temp;
	@Override
	public String toString() {
		return "DailyForecasts [Date=" + Date + ", temp=" + temp + "]";
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Temperature getTemp() {
		return temp;
	}
	public void setTemp(Temperature temp) {
		this.temp = temp;
	}
	

}
