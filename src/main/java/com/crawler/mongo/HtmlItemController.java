package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlItemController {

	@Autowired
	private HtmlItemService htmlItemService;
	
	@RequestMapping("/htmlItems")
	public List<HtmlItem> getAllHtmlItems() {
		return htmlItemService.getAllHtmlItems();
	}
}