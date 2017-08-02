package com.crawler.mongo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CrawlerAnalyzer {
	
	private CrawlerRepository repository;
	
	@Autowired
	public CrawlerAnalyzer(CrawlerRepository crawlerRepository) {
		this.repository = crawlerRepository;
	}
	
	public void Analyze() {
		System.out.println("---------------------------------------------");
		System.out.println("Performing web crawling and comparing hashes:");
		System.out.println("---------------------------------------------");
		
		for (CrawlerItem item : repository.findAll()) {
			item.getData();
			if (!item.isCurrentHashEqualToPrevious()) {
				item.setHash();
				repository.save(item);
			}
		}
		
		System.out.println();
	}
	
	//To be finished
	public void parallerAnalyze() {
		System.out.println("---------------------------------------------");
		System.out.println("Performing Analyze - Paraller version");
		System.out.println("---------------------------------------------");
		
		List<CrawlerItem> all = new LinkedList<CrawlerItem>();
		all = repository.findAll();
		all.parallelStream().forEach( (item) -> {
	        item.getData();
	    	item.isCurrentHashEqualToPrevious();
	    });
	}
}
