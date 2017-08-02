package com.crawler.mongo;

public class HtmlItem extends CrawlerItem {
	
	public String cssSelector;
	    
	public HtmlItem() {}

    public HtmlItem(String website, String cssSelector) {
        this.website = website;
        this.cssSelector = cssSelector;
        this.hash = generateHash(website, cssSelector); 
        
    }
    
    public void setHash() {
    	this.hash = generateHash(this.website, this.cssSelector);
    }
	
    public CrawlerItemHash generateHash(String website, String cssSelector) {
    	CrawlerItemHash hash = new CrawlerItemHash();
    	hash.setHashValue(website, cssSelector);
    	return hash;
    }

	@Override
	public void getData() {
		System.out.println("HTML ITEM");
		System.out.println("website: " + this.website);
		System.out.println("cssSelector: " + this.cssSelector);
		System.out.println("hash: " + this.hash.getHashValue().toString());
		System.out.println("hash date: " + this.hash.getDate().toString());
	}
	
	@Override
	public boolean isCurrentHashEqualToPrevious() {
		String currentHash = generateHash(this.website, this.cssSelector).getHashValue();
		System.out.println("current HTML hash is: " + currentHash );
		return isHashEqual(currentHash);
	}


	

}
