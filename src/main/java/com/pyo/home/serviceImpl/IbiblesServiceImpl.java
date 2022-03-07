package com.pyo.home.serviceImpl;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pyo.home.DTO.Bible;
import com.pyo.home.service.IbiblesService;

@Service
public class IbiblesServiceImpl implements IbiblesService{
	private static final Logger logger = LoggerFactory.getLogger(IbiblesServiceImpl.class);

	@Override
	public ArrayList<Bible> getBibles() {
		StringBuffer uri = new StringBuffer("");
		uri.append("https://ibibles.net/quote.php");
		uri.append("?kor-mat/5:3-6:12");
		
		WebClient client = (WebClient) WebClient.builder()
				.baseUrl(uri.toString()).build()
				.get().retrieve().bodyToMono(Bible.class);
		System.out.println(client.toString());
		return null;
	}
	
	
	

}
