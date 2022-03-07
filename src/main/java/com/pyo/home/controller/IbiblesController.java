package com.pyo.home.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyo.home.DTO.Bible;
import com.pyo.home.repository.IbibleRepository;
import com.pyo.home.service.IbiblesService;

@RestController
@RequestMapping("/Ibibles")
public class IbiblesController {
	private static final Logger logger = LoggerFactory.getLogger(IbiblesController.class);
	
	@Autowired
	private IbibleRepository ibibleRepository;
	
	@Autowired
	private IbiblesService ibiblesService;
	
	//TODO contact web api 
	@GetMapping("/getBibles")
	public String getBible() throws Exception{
		ArrayList<Bible> data = ibiblesService.getBibles();
//		ibibleRepository.saveAll(data);
		return "success";
	}
}
