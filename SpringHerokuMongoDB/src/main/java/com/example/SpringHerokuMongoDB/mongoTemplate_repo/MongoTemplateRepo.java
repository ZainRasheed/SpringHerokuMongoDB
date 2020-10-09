package com.example.SpringHerokuMongoDB.mongoTemplate_repo;

import com.example.SpringHerokuMongoDB.properties.CompanyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoTemplateRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CompanyDetails> findAll() {
        return mongoTemplate.findAll(CompanyDetails.class);
    }

    public CompanyDetails findById(Integer id) {
        return mongoTemplate.findById(id, CompanyDetails.class);
    }

    public Object save(CompanyDetails companyDetails) {
        return mongoTemplate.save(companyDetails);
    }
}
