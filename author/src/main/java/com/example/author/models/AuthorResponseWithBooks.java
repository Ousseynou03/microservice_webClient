package com.example.author.models;

import com.example.author.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
public class AuthorResponseWithBooks {
    private Long id;
    private String nom;
    private String pays;
    private List<BookResponse> bookResponses = new ArrayList<>();

    public AuthorResponseWithBooks(Author author, List<BookResponse> bookResponses){
        id = author.getId();
        nom = author.getNom();
        pays = author.getPays();
        this.bookResponses = bookResponses;

    }

}
