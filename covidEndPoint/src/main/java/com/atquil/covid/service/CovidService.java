package com.atquil.covid.service;







import java.lang.System.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CovidService {
	
	
	
	private static final String url="https://corona-virus-world-and-india-data.p.rapidapi.com/api";
	
	private static final String xRapidApiKey="9de4244012msh8d8ebc40eed0dd9p1651b3jsn9025d4c17bdd";
	
	private static final String xRapidApiHost="corona-virus-world-and-india-data.p.rapidapi.com";
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	/* OkHttpClient client = new OkHttpClient();
Request request = new Request.Builder()
	.url("https://corona-virus-world-and-india-data.p.rapidapi.com/api")
	.get()
	.addHeader("X-RapidAPI-Key", "9de4244012msh8d8ebc40eed0dd9p1651b3jsn9025d4c17bdd")
	.addHeader("X-RapidAPI-Host", "corona-virus-world-and-india-data.p.rapidapi.com")
	.build();
Response response = client.newCall(request).execute();*/
	
	public Object getAllCountryCovidData() {
		
		
		
		try {
			//Header values is set
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		   headers.set("X-RapidApi-Key","9de4244012msh8d8ebc40eed0dd9p1651b3jsn9025d4c17bdd");
		   headers.set("X-RapidApi-Host","corona-virus-world-and-india-data.p.rapidapi.com" );
		   
		   //Make a GET call to the RapidAPI
		   
		   ResponseEntity<String> response= restTemplate.exchange(url, HttpMethod.GET,new  HttpEntity<>(headers),String.class);
		
		   log.info("Output from RapidAPi",response.getBody());
		   
		   return response.getBody();
		}
		catch(Exception e) {
			log.error("Something went wrong while getting value from RapidAPI",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Exception while calling endpoint of Rapid API of Corona");
		}
		
		
	}

}
