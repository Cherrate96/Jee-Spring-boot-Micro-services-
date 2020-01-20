package com.home.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CircuitBreakerRestController {
	@GetMapping("/defaultCountries")
	public Map<String, String> countries()
	{
		Map<String, String> data=new HashMap<String, String>();
		data.put("message", "default Countries");
		data.put("countries", "Maroc,Algérie, Tunisie,...");
		return data;
	}
	
	@GetMapping("/defaultSalat")
	public Map<String, String> salat()
	{
		Map<String, String> data=new HashMap<String, String>();
		data.put("message", "Horaire Salawat En Nwakchot");

		data.put("Fajr", "7:00");
		data.put("Addhor", "14:00");
		return data;
	}


}
