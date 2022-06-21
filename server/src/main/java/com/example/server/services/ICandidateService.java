package com.example.server.services;

import com.example.server.dto.CreateOrUpdateCandidateDTO;
import com.example.server.models.Candidate;

import java.util.List;
import java.util.Optional;

public interface ICandidateService {

    Optional<Candidate> getById(Integer id);

    List<Candidate> getAll();

    Candidate create(CreateOrUpdateCandidateDTO dto);

    Candidate updateCandidate(Integer id, CreateOrUpdateCandidateDTO dto);

    void delete(Integer id);

    void vote(Integer id);

}
