package com.example.server.controller;

import com.example.server.dto.CreateOrUpdateCandidateDTO;
import com.example.server.models.Candidate;
import com.example.server.serviceImpl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {

    private final CandidateServiceImpl service;

    @Autowired
    public CandidateController(CandidateServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Candidate getOne(@PathVariable int id){
        if(service.getById(id).isPresent())
            return service.getById(id).get();
        else
            return null;
    }

    @GetMapping("/all")
    public List<Candidate> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CreateOrUpdateCandidateDTO dto){
        service.updateCandidate(id, dto);
    }

    @PostMapping()
    public Candidate create(@RequestBody CreateOrUpdateCandidateDTO dto){
        return service.create(dto);
    }

    @PostMapping("/vote/{id}")
    public void vote(@PathVariable int id){
        service.vote(id);
    }


}
