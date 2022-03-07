package com.pyo.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ibibles")
public class IbiblesController {
	private static final Logger logger = LoggerFactory.getLogger(IbiblesController.class);
	
	//TODO contact web api 
	@GetMapping("/getBibles")
	public String getBible() throws Exception{
		return "";
	}
}
