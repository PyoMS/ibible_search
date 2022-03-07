package com.pyo.home;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class BibleSearchProjectApplicationTests {

	@Test
	void contextLoads() {
		StringBuffer uri = new StringBuffer("");
		uri.append("https://ibibles.net/quote.php");
		uri.append("?kor-mat/5:3-6:12");
		
		WebClient client = WebClient.builder()
				.baseUrl(uri.toString()).build();
			
		System.out.println(client.get().retrieve().bodyToMono(DataBuffer.class));
	}

}
