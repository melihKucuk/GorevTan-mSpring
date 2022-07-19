package com.GorevTanim;


import model.gorev;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GorevRepository extends MongoRepository<gorev,String> {
}
