package com.softvision.taipc.service;

import com.softvision.taipc.entities.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> getAll();

    Candidate getCandidate(String id);

    void addCandidate(Candidate candidate);

    void deleteCandidate(String id);
}
