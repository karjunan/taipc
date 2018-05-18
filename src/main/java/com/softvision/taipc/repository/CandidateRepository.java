package com.softvision.taipc.repository;

import com.softvision.taipc.entities.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate,String> {


}
