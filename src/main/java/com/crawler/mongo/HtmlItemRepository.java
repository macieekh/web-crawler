package com.crawler.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HtmlItemRepository extends MongoRepository<HtmlItem, String> { 

    public List<HtmlItem> findByWebsite(String website);


}