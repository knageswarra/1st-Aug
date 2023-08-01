package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Stream;

public interface StreamRepository extends MongoRepository<Stream, String>{

}
