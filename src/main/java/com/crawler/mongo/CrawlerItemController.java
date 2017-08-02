package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlerItemController {

	@Autowired
	private CrawlerItemService crawlerItemService;
	
	@RequestMapping("/crawlerItems")
	public List<CrawlerItem> getAllCrawlerItems() {
		return crawlerItemService.getAllCrawlerItems();
	}
	
	@RequestMapping("/htItems")
	public List<HtmlItem> getHtmlItems() {
		return crawlerItemService.getAllHtmlItems();
	}
}