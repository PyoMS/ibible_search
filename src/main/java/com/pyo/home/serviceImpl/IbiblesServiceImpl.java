package com.pyo.home.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyo.home.DTO.Bible;
import com.pyo.home.service.IbiblesService;

@Service
public class IbiblesServiceImpl implements IbiblesService{
	private static final Logger logger = LoggerFactory.getLogger(IbiblesServiceImpl.class);
	
	@Autowired
	private Bible bible;

	@Override
	public String getBibles() {
		return null;
	}
	
	
	

}
