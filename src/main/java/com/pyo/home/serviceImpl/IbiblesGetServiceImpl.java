package com.pyo.home.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.pyo.home.DTO.Bible;
import com.pyo.home.service.IbiblesGetService;


@Service
public class IbiblesGetServiceImpl implements IbiblesGetService{
	private static final Logger logger = LoggerFactory.getLogger(IbiblesGetServiceImpl.class);

	@Override
	public List<Bible> getBibles(EnumBibleItems eb) throws Exception {
		List<Bible> result = new ArrayList<>();
		StringBuffer uri = new StringBuffer("https://ibibles.net/quote.php");
		uri.append("?kor-"+eb.getBook_eng()+"/1:1-"+eb.getLastChapter()+":"+eb.getLastVerse()); 
		
		ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)).build(); // to unlimited memory size

		WebClient client = (WebClient) WebClient.builder()
				.baseUrl(uri.toString()).exchangeStrategies(exchangeStrategies).build();
		
		String response = client.get().retrieve().bodyToMono(String.class).block();
		Document doc = Jsoup.parseBodyFragment(response);
		result = parseDoc(doc, eb.getBook_eng(), eb.toString());
		
		return result;
	}
	
	public List<Bible> parseDoc(Document doc, String book_eng, String book_kor) throws Exception{
		List<Bible> result = new ArrayList<>();
		List<Node> list = doc.body().childNodes();
		for (Node node : list) {
			Bible bible = new Bible();
			bible.setBook_eng(book_eng);
			bible.setBook_kor(book_kor);
			if(node.nodeName().equals("small") || node.nodeName()=="small") {
//				logger.info("---start---");
				String[] str = getSplitString(node.toString().trim());
				bible.setChapter(str[0]);
				bible.setVerse(str[1]);
				bible.setContents(node.nextSibling().toString().trim());
				result.add(bible);
//				logger.info("---end---");
			}
		}
		return result;
	}
	
	public String[] getSplitString(String str) throws Exception{
		String[] result = str.split(":");
		result[0] = result[0].replaceAll("<small>", "");
		result[1] = result[1].replaceAll("</small>", "");
		return result;
	}
	
	public static void main(String[] args) {
		for(EnumBibleItems eb : EnumBibleItems.values()) {
			System.out.println(eb.toString());
		}
	}
}
