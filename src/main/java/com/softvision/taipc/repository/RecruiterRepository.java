package com.softvision.taipc.repository;

import com.softvision.taipc.entities.Recruiter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecruiterRepository extends MongoRepository<Recruiter,String> {


}
