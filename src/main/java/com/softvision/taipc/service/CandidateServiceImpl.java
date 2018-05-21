package com.softvision.taipc.service;

import com.softvision.taipc.entities.Candidate;
import com.softvision.taipc.helper.Loggable;
import com.softvision.taipc.repository.CandidateRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class CandidateServiceImpl implements CandidateService<Candidate> {

    @Inject
    private CandidateRepository candidateRepository;

    @Override
    @Loggable
    public Candidate getCandidate(String id) {
        return candidateRepository.findById(id).get();
    }

    @Override
    @Loggable
    public Candidate addCandidate(Candidate candidate) {
       return candidateRepository.insert(candidate);
    }

    @Override
    @Loggable
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    @Loggable
    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);
    }

    @Override
    @Loggable
    public void deleteAllCandidates() {
        candidateRepository.deleteAll();
    }
}
