package com.crawler.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PdfItemRepository extends MongoRepository<PdfItem, String> { 

    public List<PdfItem> findByWebsite(String website);


}