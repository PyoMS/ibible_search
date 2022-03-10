package com.pyo.home;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
/**
 * init start insertDB Controller
 * */
@Component
public class InitCommandLineRunner implements CommandLineRunner{
	@Value("${server.port}")
	private String port;
	
	private final RestTemplate restTemplate;
	
	public InitCommandLineRunner(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	//TODO security 
	@Override
	public void run(String... args) throws Exception {
		StringBuffer url = new StringBuffer("http://localhost:");
		url.append(port).append("/Ibibles/getBibles");
		
		 // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
//	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
//	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//	    headers.setBasicAuth(port, port)
	    // create a map for post parameters
	    Map<String, Object> map = new HashMap<>();
//	    map.put("userId", 1);
//	    map.put("title", "Introduction to Spring Boot");
//	    map.put("body", "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications.");

	    // build the request
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
		
		this.restTemplate.postForObject(url.toString(), entity, String.class);
	}

}
