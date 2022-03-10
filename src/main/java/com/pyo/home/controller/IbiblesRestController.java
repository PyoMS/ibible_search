package com.pyo.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyo.home.DTO.Bible;
import com.pyo.home.repository.IbibleRepository;

@RestController
@RequestMapping("/getContents")
public class IbiblesRestController {
	@Autowired
	IbibleRepository ibibleRepository;
	
	@GetMapping("/{contents}")
	public List<Bible> retrieveContents(@PathVariable String contents) throws Exception{
		System.out.println("@retrieveContents");
		List<Bible> biblelist = ibibleRepository.findAllContents(contents);
		
		return biblelist;
	}

}
