package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrawlerItemService {
	@Autowired
	private CrawlerRepository repository;
	
	List<CrawlerItem> getAllCrawlerItems() {
		return repository.findAll();
	}
	
	List<HtmlItem> getAllHtmlItems() {
		return repository.findHtmlItems("com.crawler.mongo.HtmlItem");
	}
}
