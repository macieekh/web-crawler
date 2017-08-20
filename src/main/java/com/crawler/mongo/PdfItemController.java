package com.crawler.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfItemController {

	@Autowired
	private PdfItemService pdfItemService;
	
	@RequestMapping("/pdfItems")
	public List<PdfItem> getAllPdfItems() {
		return pdfItemService.getAllPdfItems();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/pdfItems/{id}")
	public ResponseEntity<PdfItem> findOne(@PathVariable("id") String id) {
		PdfItem foundItem = pdfItemService.findOne(id);
		if (foundItem != null) {
	        return new ResponseEntity<PdfItem>(foundItem, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/pdfItems/{id}")
	public ResponseEntity<PdfItem> delete(@PathVariable("id") String id) {
		PdfItem foundItem = pdfItemService.findOne(id);
		if (foundItem != null) {
			pdfItemService.deleteById(id);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/pdfItems")
	public void addPdfItem(@RequestBody PdfItem pdfItem) {
		pdfItemService.addPdfItem(pdfItem);
	}
}