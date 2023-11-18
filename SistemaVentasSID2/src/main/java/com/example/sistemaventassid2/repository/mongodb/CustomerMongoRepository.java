package com.example.sistemaventassid2.repository.mongodb;

import com.example.sistemaventassid2.model.mongodb.CustomerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerMongoRepository extends MongoRepository<CustomerMongo, String> {
}
