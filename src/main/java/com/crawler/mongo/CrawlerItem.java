package com.crawler.mongo;

import org.springframework.data.annotation.Id;


public abstract class CrawlerItem {

	protected CrawlerItemHash hash;
	
	protected abstract void getData();
	protected abstract void setHash();
	protected abstract boolean isCurrentHashEqualToPrevious();
	
	public CrawlerItemHash getHash() {
		return hash;
	}
	public void setHash(CrawlerItemHash hash) {
		this.hash = hash;
	}
	
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
