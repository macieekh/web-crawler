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
public class HtmlItemController {

	@Autowired
	private HtmlItemService htmlItemService;
	
	@RequestMapping("/htmlItems")
	public List<HtmlItem> getAllHtmlItems() {
		return htmlItemService.getAllHtmlItems();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/htmlItems/{id}")
	public ResponseEntity<HtmlItem> findOne(@PathVariable("id") String id) {
		HtmlItem foundItem = htmlItemService.findOne(id);
		if (foundItem != null) {
	        return new ResponseEntity<HtmlItem>(foundItem, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//return htmlItemService.findOne(id);
	}
	
	@RequestMapping(value = "/htmlItems/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HtmlItem> delete(@PathVariable("id") String id) {
		HtmlItem foundItem = htmlItemService.findOne(id);
		if (foundItem != null) {
			htmlItemService.deleteById(id);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/htmlItems")
	public void addHtmlItem(@RequestBody HtmlItem htmlItem) {
		htmlItemService.addHtmlItem(htmlItem);
	}
}