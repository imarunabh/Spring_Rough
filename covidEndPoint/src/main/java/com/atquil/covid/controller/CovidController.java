package com.atquil.covid.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atquil.covid.service.CovidService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/covid")
@RequiredArgsConstructor
public class CovidController {
	
	
	private final CovidService covidService;
	
	@GetMapping("/get-all-country-covid-data")
	public ResponseEntity<?> callRapidEndPointToGetCovidData(){
		return ResponseEntity.ok(covidService.getAllCountryCovidData());
		
	}

}
