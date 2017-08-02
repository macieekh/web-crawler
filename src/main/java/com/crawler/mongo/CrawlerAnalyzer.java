package com.crawler.mongo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CrawlerAnalyzer {
	
	private PdfItemRepository pdfItemRepository;
	private HtmlItemRepository htmlItemRepository;
	
	@Autowired
	public CrawlerAnalyzer(PdfItemRepository pdfItemRepository, HtmlItemRepository htmlItemRepository) {
		this.pdfItemRepository = pdfItemRepository;
		this.htmlItemRepository = htmlItemRepository;		
	}
	
	public void Analyze() {
		System.out.println("---------------------------------------------");
		System.out.println("Performing web crawling and comparing hashes:");
		System.out.println("---------------------------------------------");
		
		for (HtmlItem item : htmlItemRepository.findAll()) {
			item.getData();
			if (!item.isCurrentHashEqualToPrevious()) {
				item.setHash();
				htmlItemRepository.save(item);
			}
		}
		
		System.out.println();
		
		
		for (PdfItem item : pdfItemRepository.findAll()) {
			item.getData();
			if (!item.isCurrentHashEqualToPrevious()) {
				item.setHash();
				pdfItemRepository.save(item);
			}
		}
	}
	
	
	
	
	
	//To be finished
	/*
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
	*/
}
