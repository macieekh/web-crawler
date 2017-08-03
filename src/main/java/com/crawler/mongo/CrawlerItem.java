package com.crawler.mongo;

import org.springframework.data.annotation.Id;


public abstract class CrawlerItem {
	
	@Id
    protected String id;
	protected CrawlerItemHash hash;
	
	
	public abstract void getData();
	protected abstract void setHash();
	protected abstract boolean isCurrentHashEqualToPrevious();
	
	/*@JsonIgnore
	public void analyzeData(PdfItemRepository pdfItemRepository ) {
		for (PdfItem item : pdfItemRepository.findAll()) {
			item.getData();
			System.out.println("lalala from pdf");
			if (!item.isCurrentHashEqualToPrevious()) {
				item.setHash();
				pdfItemRepository.save(item);
			}
		}
	}*/
	
	public String getId() {
		return id;
	}

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
