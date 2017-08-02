package com.crawler.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;



public interface CrawlerRepository extends MongoRepository<CrawlerItem, String> { 

    public List<CrawlerItem> findByWebsite(String website);
    
    @Query(" {'_class': ?0 } ")
    public List<HtmlItem> findHtmlItems(String name);


}








