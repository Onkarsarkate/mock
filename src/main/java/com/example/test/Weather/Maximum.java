package com.example.test.Weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maximum {
	@JsonProperty("Value")
	private int Value;
	@JsonProperty("Unit")
	private String Unit;
	@Override
	public String toString() {
		return "Maximum [Value=" + Value + ", Unit=" + Unit + "]";
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	
}
