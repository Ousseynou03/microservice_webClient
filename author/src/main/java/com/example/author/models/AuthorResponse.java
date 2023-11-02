package com.example.author.models;

import com.example.author.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthorResponse {
    private Long id;
    private String nom;
    private String pays;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.nom = author.getNom();
        this.pays = author.getPays();
    }
}
