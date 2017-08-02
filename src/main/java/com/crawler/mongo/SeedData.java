package com.crawler.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData {
		
	private CrawlerRepository repository;

	@Autowired
	public SeedData(CrawlerRepository crawlerRepository) {
		this.repository = crawlerRepository;
	}


	public void loadData() {
		
		//remove this line to keep DB persistent
		repository.deleteAll();
		
		//BZWBK
		repository.save(new HtmlItem(
			"https://www.bzwbk.pl/przydatne-informacje/toip/dla-klientow-indywidualnych/taryfa-oplat-i-prowizji.html",
			"#sub-page > div.content > div > div:nth-child(1) > div.left.content > div:nth-child(1) > ul > li > a"
		));
		repository.save(new PdfItem("https://static3.bzwbk.pl/asset/t/a/r/taryfa_dla_ciebie_30580.pdf"));
		
		//PKOBP
		repository.save(new HtmlItem(
				"https://www.pkobp.pl/oplaty-i-prowizje/",
				"#toip-filter > main > div:nth-child(2) > div:nth-child(2) > div > ul > li:nth-child(1) > a"
		));
		repository.save(new PdfItem("https://www.pkobp.pl/media_files/85606866-3b09-4d53-81bb-f567a7fa6711.pdf"));

		//ING
		repository.save(new HtmlItem(
				"https://www.ingbank.pl/indywidualni/tabele-i-regulaminy/tabela-oplat-i-prowizji",
				"#2146415 > p:nth-child(1) > a > span"
		));
		repository.save(new PdfItem("https://www.ingbank.pl/_fileserver/item/1000192"));
		
		//CA
		repository.save(new PdfItem("https://www.credit-agricole.pl/dokumenty/konta/toip-indywidualni"));
		
	}
	
	
	 

	   
}
