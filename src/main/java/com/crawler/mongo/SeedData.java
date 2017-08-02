package com.crawler.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData {
		
	private PdfItemRepository pdfItemRepository;
	private HtmlItemRepository htmlItemRepository;

	@Autowired
	public SeedData(PdfItemRepository pdfItemRepository, HtmlItemRepository htmlItemRepository) {
		this.pdfItemRepository = pdfItemRepository;
		this.htmlItemRepository = htmlItemRepository;
	}


	public void loadData() {
		
		//remove this lines to keep DB persistent
		pdfItemRepository.deleteAll();
		htmlItemRepository.deleteAll();
		
		//BZWBK
		htmlItemRepository.save(new HtmlItem(
			"https://www.bzwbk.pl/przydatne-informacje/toip/dla-klientow-indywidualnych/taryfa-oplat-i-prowizji.html",
			"#sub-page > div.content > div > div:nth-child(1) > div.left.content > div:nth-child(1) > ul > li > a"
		));
		pdfItemRepository.save(new PdfItem("https://static3.bzwbk.pl/asset/t/a/r/taryfa_dla_ciebie_30580.pdf"));
		
		//PKOBP
		htmlItemRepository.save(new HtmlItem(
				"https://www.pkobp.pl/oplaty-i-prowizje/",
				"#toip-filter > main > div:nth-child(2) > div:nth-child(2) > div > ul > li:nth-child(1) > a"
		));
		pdfItemRepository.save(new PdfItem("https://www.pkobp.pl/media_files/85606866-3b09-4d53-81bb-f567a7fa6711.pdf"));

		//ING
		htmlItemRepository.save(new HtmlItem(
				"https://www.ingbank.pl/indywidualni/tabele-i-regulaminy/tabela-oplat-i-prowizji",
				"#2146415 > p:nth-child(1) > a > span"
		));
		pdfItemRepository.save(new PdfItem("https://www.ingbank.pl/_fileserver/item/1000192"));
		
		//CA
		pdfItemRepository.save(new PdfItem("https://www.credit-agricole.pl/dokumenty/konta/toip-indywidualni"));
		
	}
	
	
	 

	   
}
