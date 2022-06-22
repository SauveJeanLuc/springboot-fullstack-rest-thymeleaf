package com.example.client.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Candidate {

    private Integer id;

    private String name;

    private String profileUrl;

    private Integer votes;

}
