package com.example.test.Weather;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.test.Weather.controller.WeatherControllerAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootTest
class WeatherApplicationTests {
	@Autowired
	private WeatherControllerAPI controller;

	@Test
	public void contextLoads() throws JsonMappingException, JsonProcessingException {
		ResponseEntity<String> s;
		s = controller.getWeather("pune");
		assertNotNull(s); // test case for checking result is not null
		assertEquals(HttpStatus.OK , s.getStatusCode());
		s = controller.getWeather("abc");
		assertEquals(HttpStatus.BAD_REQUEST, s.getStatusCode());// test case for checking bad request

	}

}
