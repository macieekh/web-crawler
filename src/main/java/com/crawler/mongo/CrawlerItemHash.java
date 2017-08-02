package com.crawler.mongo;
import java.util.*;

import org.jsoup.select.Elements;
import com.crawler.hash.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CrawlerItemHash {
	private String hashValue;
	private Date hashDate;
	
	
	public CrawlerItemHash() {
		this.hashDate = new Date();
	}
	
	public String getHashValue() {
		return hashValue;
	}
	
	//set hash for url and css selector
	public void setHashValue(String website, String cssSelector) {	
		Document doc;
		Elements selector = null;
		try {
			doc = Jsoup.connect(website).get();
			selector = doc.select(cssSelector);
			
			String inputString = selector.text().toString();
			System.out.println("selector text" + inputString);
			
			String md5Hash = HashGenerator.generateMD5(inputString);
			System.out.println("MD5 Hash html: " + md5Hash);
            this.hashValue = md5Hash;
		} catch (IOException | HashGenerationException ex) {
			ex.printStackTrace();
		} 
	}
	
	//setHash for file
	public void setHashValue(String webfile) {
		this.hashValue = "website not found";
		URL url = null;
		
		
		try {
			url = new URL(webfile);
			InputStream is = url.openStream();
			MessageDigest digest = MessageDigest.getInstance("MD5");
			 
	        byte[] bytesBuffer = new byte[1024];
	        int bytesRead = -1;
	 
	        while ((bytesRead = is.read(bytesBuffer)) != -1) {
	            digest.update(bytesBuffer, 0, bytesRead);
	        }
	        
	        byte[] hashedBytes = digest.digest();
	        is.close();
			
	        this.hashValue = convertByteArrayToHexString(hashedBytes);
	        System.out.println("MD5 Hash PDF: " + this.hashValue);
	        
		} catch (NoSuchAlgorithmException | IOException ex) {
			 ex.printStackTrace();
		}
	}
	
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < arrayBytes.length; i++) {
	        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return stringBuffer.toString();
	}
	
	
	public Date getDate() {
		return hashDate;
	}
	public void setDate(Date date) {
		this.hashDate = date;
	}
	
	
}
