package com.pyo.home.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pyo.home.DTO.Bible;

@Service
public interface IbiblesService {
	public List<Bible> getBibles() throws Exception;
	
}
