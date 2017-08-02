package com.crawler.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface CrawlerRepository extends MongoRepository<CrawlerItem, String> { 

    public List<CrawlerItem> findByWebsite(String website);


}





