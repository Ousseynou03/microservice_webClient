package com.mybook.mybook.models;

public class BookRequest {
    private String titre;
    private double prix;
    private Long author_id;

    public BookRequest(String titre, double prix, Long author_id) {
        this.titre = titre;
        this.prix = prix;
        this.author_id = author_id;
    }

    public BookRequest() {
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

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }
}
