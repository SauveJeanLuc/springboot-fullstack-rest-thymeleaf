package com.example.server.serviceImpl;

import com.example.server.dto.CreateOrUpdateCandidateDTO;
import com.example.server.models.Candidate;
import com.example.server.repository.ICandidateRepository;
import com.example.server.services.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements ICandidateService {
    private final ICandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(ICandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Optional<Candidate> getById(Integer id) {

        return candidateRepository.findById(id);
    }

    @Override
    public List<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate create(CreateOrUpdateCandidateDTO dto) {
        Candidate  candidate = new Candidate(dto);

        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Integer id, CreateOrUpdateCandidateDTO dto) {

        Optional<Candidate> existingCandidate = candidateRepository.findById(id);
        if(existingCandidate.isPresent()){
            existingCandidate.get().setName(dto.getName());
            existingCandidate.get().setProfileUrl(dto.getProfileUrl());
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public void vote(Integer id) {
        Optional<Candidate> existingCandidate = candidateRepository.findById(id);
        if(existingCandidate.isPresent()){
            Integer currentVote = existingCandidate.get().getVotes();
            existingCandidate.get().setVotes(currentVote+1);
        }
        candidateRepository.save(existingCandidate.get());
    }
}
