package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfItemService {
	@Autowired
	private PdfItemRepository pdfItemRepository;
	
	List<PdfItem> getAllPdfItems() {
		return pdfItemRepository.findAll();
	}
}

