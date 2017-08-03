package com.crawler.mongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CrawlerMongoApplication implements CommandLineRunner {

	@Autowired
	private PdfItemRepository pdfItemRepository;
	@Autowired
	private HtmlItemRepository htmlItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CrawlerMongoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SeedData seedData = new SeedData(pdfItemRepository, htmlItemRepository);
		seedData.loadData();
		
		/* Uncomment to get some time to change file on ftp so crawler can detect changes - for initial testing purposes only!
		System.out.println("Press any key to continue");
		System.in.read();*/
		
		CrawlerAnalyzer crawlerAnalyzer = new CrawlerAnalyzer(pdfItemRepository, htmlItemRepository);
		crawlerAnalyzer.analyze();


	}

}
