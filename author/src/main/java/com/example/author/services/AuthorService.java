package com.example.author.services;

import com.example.author.models.AuthorRequest;
import com.example.author.models.AuthorResponse;
import com.example.author.models.AuthorResponseWithBooks;

import java.util.List;

public interface AuthorService {
    AuthorResponse getOneAuthor(Long id);

    AuthorResponse addAuthor(AuthorRequest authorRequest);

    List<AuthorResponse> getAll();

    AuthorResponse updateAuthor(AuthorRequest authorRequest, Long id);

    String deleteAuthor(Long id);
    AuthorResponseWithBooks authorWithBooks(Long id);

}
