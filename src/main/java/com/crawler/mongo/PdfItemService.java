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
	
	public PdfItem findOne(String id) {
		return pdfItemRepository.findOne(id);
	}
	public void deleteById(String id) {
		pdfItemRepository.delete(id);
	}
	
	public void addPdfItem(PdfItem pdfItem) {
		PdfItem newItem = new PdfItem(pdfItem.getWebsite());
		pdfItemRepository.insert(newItem);
	}
	
}

