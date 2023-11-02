package com.mybook.mybook.models;

import com.mybook.mybook.entities.Book;



public class BookResponse {
    private Long id;
    private String titre;
    private double prix;
    private AuthorResponse authorResponse;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.titre = book.getTitre();
        this.prix = book.getPrix();

    }
    public BookResponse(Book book,AuthorResponse authorResponse) {
        this.id = book.getId();
        this.titre = book.getTitre();
        this.prix = book.getPrix();
        this.authorResponse = authorResponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public AuthorResponse getAuthorResponse() {
        return authorResponse;
    }

    public void setAuthorResponse(AuthorResponse authorResponse) {
        this.authorResponse = authorResponse;
    }
}
