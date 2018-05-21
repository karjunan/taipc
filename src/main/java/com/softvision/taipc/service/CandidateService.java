package com.softvision.taipc.service;

import com.softvision.taipc.entities.Candidate;

import java.util.List;

public interface CandidateService<T extends  Candidate> {

    List<T> getAll();

    T getCandidate(String id);

    T addCandidate(T candidate);

    void deleteCandidate(String id);

    void deleteAllCandidates();
}
