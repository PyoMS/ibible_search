package com.pyo.home.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.pyo.home.DTO.Bible;

@Service
public interface IbiblesService {
	public ArrayList<Bible> getBibles();
	
}
