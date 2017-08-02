package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HtmlItemService {
	@Autowired
	private HtmlItemRepository repository;
	
	List<HtmlItem> getAllHtmlItems() {
		return repository.findAll();
	}
}

