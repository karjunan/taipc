package com.softvision.taipc.service;

import com.softvision.taipc.entities.Candidate;
import com.softvision.taipc.helper.Loggable;
import com.softvision.taipc.repository.CandidateRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class CandidateServiceImpl implements CandidateService {

    @Inject
    private CandidateRepository candidateRepository;

    @Override
    @Loggable
    public Candidate getCandidate(String id) {
        return candidateRepository.findById(id).get();
    }

    @Override
    @Loggable
    public void addCandidate(Candidate candidate) {
        candidateRepository.insert(candidate);
    }

    @Override
    @Loggable
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    @Loggable
    public void deleteCandidate(String id) {
        System.out.println("Deleting id " + id);
        candidateRepository.deleteById(id);
    }
}
