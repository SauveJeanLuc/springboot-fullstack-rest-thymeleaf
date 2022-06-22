package com.example.client.api;


import com.example.client.model.Candidate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
@RequestMapping("/client")
public class CandidateApi {

    @GetMapping
    String getOne(Model model){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("header", "value");

        HttpEntity<Candidate> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<Candidate> candidateResponse = restTemplate.exchange("http://localhost:8080/api/v1/candidates/1", HttpMethod.GET,requestEntity, Candidate.class);

        model.addAttribute("candidate", candidateResponse.getBody());

        return "user";
    }

    @GetMapping("/all")
    String getAllPeople(Model model){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("header", "value");

        HttpEntity<Candidate> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<List> candidateResponse = restTemplate.exchange("http://localhost:8080/api/v1/candidates/all", HttpMethod.GET,requestEntity, List.class);

        List<Candidate> candidateList = candidateResponse.getBody();

        model.addAttribute("candidates", candidateList);

        return "user";
    }

    @PostMapping("/vote/{id}")
    String vote(@PathVariable int id){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("header", "value");

        HttpEntity<Candidate> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity candidateResponse = restTemplate.exchange(String.format("http://localhost:8080/api/v1/candidates/vote/%s", id), HttpMethod.POST,requestEntity, Object.class);

        return "redirect:/client/all";
    }



}
