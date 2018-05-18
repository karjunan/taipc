package com.softvision.taipc.repository;

import com.softvision.taipc.entities.Recruiter;
import com.softvision.taipc.entities.State;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StateRepository extends MongoRepository<State,String> {


}
