package com.pyo.home.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pyo.home.DTO.Bible;
import com.pyo.home.serviceImpl.EnumBibleItems;

@Service
public interface IbiblesGetService {
	public List<Bible> getBibles(EnumBibleItems eb) throws Exception;
	
}
