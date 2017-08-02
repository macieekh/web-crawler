package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfItemController {

	@Autowired
	private PdfItemService pdfItemService;
	
	@RequestMapping("/pdfItems")
	public List<PdfItem> getAllPdfItems() {
		return pdfItemService.getAllPdfItems();
	}
}