package com.example.author.controller;

import com.example.author.models.AuthorRequest;
import com.example.author.models.AuthorResponse;
import com.example.author.models.AuthorResponseWithBooks;
import com.example.author.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public AuthorResponse addAuthor(@RequestBody AuthorRequest authorRequest)
    {
        return authorService.addAuthor(authorRequest);
    }

    //---------------------------//
    @GetMapping("/authors")
    public List<AuthorResponse> allAuthors()
    {
        return authorService.getAll();
    }

    //---------------------------//

    @GetMapping("/{id}")
    public AuthorResponse getOneAuthor(@PathVariable("id") Long id){
        return authorService.getOneAuthor(id);
    }

    @PostMapping("/update/{id}")
    public AuthorResponse updateAuthor(@PathVariable("id") Long id,@RequestBody AuthorRequest authorRequest)
    {
        return authorService.updateAuthor(authorRequest,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAuth(@PathVariable("id") Long id){
        return authorService.deleteAuthor(id);
    }
    @GetMapping("/books/{id}")
    public AuthorResponseWithBooks authorBooks(@PathVariable("id") Long id){
        return authorService.authorWithBooks(id);
    }


}
