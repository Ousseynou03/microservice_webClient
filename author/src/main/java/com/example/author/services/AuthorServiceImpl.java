package com.example.author.services;

import com.example.author.entities.Author;
import com.example.author.models.AuthorRequest;
import com.example.author.models.AuthorResponse;
import com.example.author.models.AuthorResponseWithBooks;
import com.example.author.models.BookResponse;
import com.example.author.repositories.AuthorRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService{
    /* @Autowired
    private AuthorRepo authorRepo;
     */
    @Autowired
    private WebClient webClient;
    private AuthorRepo authorRepo;
    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public AuthorResponse getOneAuthor(Long id) {
        Optional<Author> author = authorRepo.findById(id);
        if(author.isPresent()){
            return new AuthorResponse(author.get());
        }
        else {
            throw new EntityNotFoundException("Author with id: "+id+" Not Found");
        }
    }

    @Override
    public AuthorResponse addAuthor(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setNom(authorRequest.getNom());
        author.setPays(authorRequest.getPays());
        authorRepo.save(author);
        AuthorResponse authorRes = new AuthorResponse(author);
        return authorRes;
    }

    @Override
    public List<AuthorResponse> getAll() {
        List<Author> authors = authorRepo.findAll();
        List<AuthorResponse> repAuthors= new ArrayList<>();
        for (Author aut: authors)
        {
            repAuthors.add(new AuthorResponse(aut));
        }
        return repAuthors;
    }

    @Override
    public AuthorResponse updateAuthor(AuthorRequest authorRequest, Long id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if(optionalAuthor.isPresent()){
            //update
            Author existAuthor = optionalAuthor.get();
            existAuthor.setNom(authorRequest.getNom());
            existAuthor.setPays(authorRequest.getPays());
            //save
            authorRepo.save(existAuthor);
            return new AuthorResponse(existAuthor);
        }
        else {
            throw new EntityNotFoundException("Author with ID :" + id + "not found");

        }



    }

    @Override
    public String deleteAuthor(Long id) {
         boolean authExist=authorRepo.existsById(id);
         if(!authExist){
             throw new EntityNotFoundException("erreur author not found,with id:"+id);
         }
         else{
             authorRepo.deleteById(id);
             return "author deleted";
         }
    }
    //-------------------------------------

    @Override
    public AuthorResponseWithBooks authorWithBooks(Long id) {
        Optional<Author> author = authorRepo.findById(id);
        if(author.isPresent()){
            //------------------------Avec Flux-------------------
           /* Flux<BookResponse> bookResponseFlux = webClient.get()
                    .uri("http://localhost:8080/api/book/books/author/"+id)
                    .retrieve()
                    .bodyToFlux(BookResponse.class);
            //---------------convert to list --------------
            List<BookResponse> bookResponses = bookResponseFlux.collect(Collectors.toList())
                    .share()
                    .block();
            AuthorResponseWithBooks authorResponseWithBooks = new AuthorResponseWithBooks(author.get(),bookResponses);
                    */
            //------------------------Avec Mono-------------------
            Mono<BookResponse[]> bookResponsesMono = webClient.get()
                    .uri("http://localhost:8087/api/book/books/author/"+id)
                    .retrieve()
                    .bodyToMono(BookResponse[].class);

            BookResponse[] bookResponses = bookResponsesMono.share().block();
            AuthorResponseWithBooks authorResponseWithBooks = new AuthorResponseWithBooks(author.get(), Arrays.asList(bookResponses));
           //---------------------------------------------------------------------
            return authorResponseWithBooks;

        }else{
            throw new EntityNotFoundException("Author with "+id+" not found!");
        }

    }


    //-------------------------------------
}
