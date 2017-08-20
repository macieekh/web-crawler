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
	
	public HtmlItem findOne(String id) {
		return htmlItemRepository.findOne(id);
	}
	
	public void deleteById(String id) {
		htmlItemRepository.delete(id);
	}
	
	public void addHtmlItem(HtmlItem htmlItem) {
		HtmlItem newItem = new HtmlItem(htmlItem.getWebsite(), htmlItem.getCssSelector());
		htmlItemRepository.insert(newItem);
	}
	
}

