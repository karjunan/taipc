package com.softvision.taipc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softvision.taipc.entities.Event;

public interface EventRepository extends MongoRepository<Event,String> {


}
