package com.pyo.home.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
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
	public List<Bible> getBibles() throws Exception {
		List<Bible> result = new ArrayList<>();
		StringBuffer uri = new StringBuffer("");
		uri.append("https://ibibles.net/quote.php");
		uri.append("?kor-mat/5:3-6:12"); //TODO All list 조건으로 처리할 것.
		
		WebClient client = (WebClient) WebClient.builder()
				.baseUrl(uri.toString()).build();
		String response = client.get().retrieve().bodyToMono(String.class).block();
		Document doc = Jsoup.parseBodyFragment(response);
		result = parseDoc(doc, "mat");
		return result;
	}
	
	public List<Bible> parseDoc(Document doc, String book) throws Exception{
		List<Bible> result = new ArrayList<>();
		List<Node> list = doc.body().childNodes();
		for (Node node : list) {
			Bible bible = new Bible();
			bible.setBook(book);
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
}
