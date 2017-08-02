package com.crawler.mongo;

import org.springframework.data.annotation.Id;

public class HtmlItem  {
	
	
	@Id
    private String id;
	protected String type;
	protected String website;
	protected CrawlerItemHash hash;
	private String cssSelector;
	    
	
	public HtmlItem() {}
	
    public HtmlItem(String website, String cssSelector) {
        this.website = website;
        this.cssSelector = cssSelector;
        this.hash = generateHash(website, cssSelector); 
        
    }
    
    
    /////////////////////////
    
    public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
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
    
    
    
    
    
    
    
    ///////////////////////
    
    
    public String getCssSelector() {
		return cssSelector;
	}

    
    public void setHash() {
    	this.hash = generateHash(this.website, this.cssSelector);
    }
	
    public CrawlerItemHash generateHash(String website, String cssSelector) {
    	CrawlerItemHash hash = new CrawlerItemHash();
    	hash.setHashValue(website, cssSelector);
    	return hash;
    }


	public void getData() {
		System.out.println("HTML ITEM");
		System.out.println("website: " + this.website);
		System.out.println("cssSelector: " + this.cssSelector);
		System.out.println("hash: " + this.hash.getHashValue().toString());
		System.out.println("hash date: " + this.hash.getDate().toString());
	}
	

	public boolean isCurrentHashEqualToPrevious() {
		String currentHash = generateHash(this.website, this.cssSelector).getHashValue();
		System.out.println("current HTML hash is: " + currentHash );
		return isHashEqual(currentHash);
	}


	

}
