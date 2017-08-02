package com.crawler.mongo;

public class PdfItem extends CrawlerItem {
	
    
	public PdfItem() {}

    public PdfItem(String website) {
    	this.website = website;
        this.hash = generateHash(website); 
    	
    }
    
    public void setHash() {
    	this.hash = generateHash(this.website);
    }

    public CrawlerItemHash generateHash(String website) {
    	CrawlerItemHash hash = new CrawlerItemHash();
    	hash.setHashValue(website);
    	return hash;
    }
	
	@Override
	public void getData() {
		System.out.println("PDF ITEM");
		System.out.println("web file: " + this.website);
		System.out.println("pdf item hash: " + this.hash.getHashValue().toString()); 
	}

	@Override
	public boolean isCurrentHashEqualToPrevious() {
		String currentHash = generateHash(this.website).getHashValue();
		System.out.println("current pdf hash is: " + currentHash);
		return isHashEqual(currentHash);
	}

	

}
