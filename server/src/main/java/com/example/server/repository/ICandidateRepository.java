package com.example.server.repository;

import com.example.server.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

}
