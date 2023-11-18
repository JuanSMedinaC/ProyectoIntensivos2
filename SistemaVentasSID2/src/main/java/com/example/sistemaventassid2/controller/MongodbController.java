package com.example.sistemaventassid2.controller;

import com.example.sistemaventassid2.model.mongodb.CustomerMongo;
import com.example.sistemaventassid2.repository.mongodb.CustomerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mongodb")
public class MongodbController {

    private final CustomerMongoRepository customerMongoRepository;

    @Autowired
    public MongodbController(CustomerMongoRepository customerMongoRepository) {
        this.customerMongoRepository = customerMongoRepository;
    }

    @PostMapping(value = "/customers/additional-info", consumes = "application/json")
    public ResponseEntity<String> addAdditionalInfo(@RequestBody CustomerMongo additionalInfo) {
        customerMongoRepository.save(additionalInfo);
        return ResponseEntity.ok("Additional information added successfully.");
    }
}

