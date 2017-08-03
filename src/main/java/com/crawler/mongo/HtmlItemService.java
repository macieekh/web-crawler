package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HtmlItemService {
	@Autowired
	private HtmlItemRepository htmlItemRepository;
	
	public List<HtmlItem> getAllHtmlItems() {
		return htmlItemRepository.findAll();
	}
	
	public void addHtmlItem(HtmlItem htmlItem) {
		HtmlItem nnn = new HtmlItem(htmlItem.getWebsite(), htmlItem.getCssSelector());
		htmlItemRepository.insert(nnn);
	}
}

