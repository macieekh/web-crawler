package com.crawler.mongo;

import org.springframework.data.annotation.Id;


public abstract class CrawlerItem {
	
	@Id
    private String id;
	protected String type;
	protected String website;
	protected CrawlerItemHash hash;
	
	protected abstract void getData();
	protected abstract void setHash();
	protected abstract boolean isCurrentHashEqualToPrevious();
	
	
	
	public boolean isHashEqual(String currentHash) {
		if (this.hash.getHashValue().equals(currentHash)) {
			System.out.println("nothing has changed - hashes equal \n");	
			return true;
		} else {
			System.out.println("there are some changes - check website/file \n");
			return false;
		}
	}
}
