package com.example.test.Weather.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.test.Weather.Location;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.json.*;
@Controller
@RequestMapping("Weather")
public class WeatherControllerAPI {
	
	 @Autowired
	   RestTemplate restTemplate;


	@GetMapping("/{cityName}")
	public ResponseEntity<String> getWeather(@PathVariable String cityName)
			throws JsonMappingException, JsonProcessingException {
		String api_key="9Dqr6s3kK5xBBvZ3gQmxJCIVN758T5A1";

		final String uri = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="+api_key+"&q="
				+ cityName + "&language=en-us";
		RestTemplate restTemplate = new RestTemplate();
		Location[] loc = restTemplate.getForObject(uri, Location[].class);

		try {
			final String uri1 = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/" + loc[0].getKey()
					+ "?apikey="+api_key+"&language=en-us";
			RestTemplate restTemplate1 = new RestTemplate();

			String loc1 = restTemplate1.getForObject(uri1, String.class);
			
			JSONObject obj = new JSONObject(loc1);
		     JSONObject jsonObject = new JSONObject();

			JSONArray arr = obj.getJSONArray("DailyForecasts");
			String WeatheDetails=null;
			for (int i = 0; i < arr.length(); i++)
			{
			    String date = arr.getJSONObject(i).getString("Date");
			    String Temp_min_value=arr.getJSONObject(i).getJSONObject("Temperature").getJSONObject("Minimum").getString("Value");
			    String Temp_min_value_unit=arr.getJSONObject(i).getJSONObject("Temperature").getJSONObject("Minimum").getString("Unit");	

			    String Temp_max_value=arr.getJSONObject(i).getJSONObject("Temperature").getJSONObject("Maximum").getString("Value");
			    String Temp_max_value_unit=arr.getJSONObject(i).getJSONObject("Temperature").getJSONObject("Maximum").getString("Unit");	
			    
			    String day=arr.getJSONObject(i).getJSONObject("Day").getString("IconPhrase");
			    String night=arr.getJSONObject(i).getJSONObject("Night").getString("IconPhrase");
			    
			     jsonObject.put("City", cityName);

			     jsonObject.put("date", date);
			     jsonObject.put("TemperatureMinimum", Temp_min_value);
			     jsonObject.put("TemperatureMaximum", Temp_max_value);
			     jsonObject.put("TemperatureUnit", Temp_max_value_unit);

			     jsonObject.put("DayWeather", day);
			     jsonObject.put("NightWeather", night);


			}
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);

		} catch (Exception ex) {
			System.out.println("Please enter valid city name");
			 JSONObject errorObject = new JSONObject();		
			 try {
				errorObject.put("error", "Please enter valid city name");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 return new ResponseEntity<String>(errorObject.toString(), HttpStatus.BAD_REQUEST);
		}

	}

}
