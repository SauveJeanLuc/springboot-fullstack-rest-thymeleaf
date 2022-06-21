package com.example.server.models;

import com.example.server.dto.CreateOrUpdateCandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String name;

    private String profileUrl;

    private Integer votes;

    public Candidate(CreateOrUpdateCandidateDTO dto) {
        this.name = dto.getName();
        this.profileUrl = dto.getProfileUrl();
        this.votes = 0;
    }
}
