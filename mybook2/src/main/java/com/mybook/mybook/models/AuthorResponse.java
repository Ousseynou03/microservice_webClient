package com.mybook.mybook.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AuthorResponse {
    private Long id;
    private String nom;
    private String pays;
}
