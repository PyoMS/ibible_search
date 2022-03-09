package com.pyo.home.controller;

import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyo.home.DTO.Bible;
import com.pyo.home.repository.IbibleRepository;
import com.pyo.home.service.IbiblesGetService;
import com.pyo.home.serviceImpl.EnumBibleItems;

@RestController
@RequestMapping("/Ibibles")
public class IbiblesGetController {
	private static final Logger logger = LoggerFactory.getLogger(IbiblesGetController.class);
	
	@Autowired
	private IbibleRepository ibibleRepository;
	
	@Autowired
	private IbiblesGetService ibiblesService;
	
	@PostMapping("/getBibles")
	@Transactional
	public String getBible() throws Exception{
		try {
			for(EnumBibleItems eb : EnumBibleItems.values()) {
				List<Bible> data = ibiblesService.getBibles(eb);
				ibibleRepository.saveAll(data);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return "success";
	}
}
