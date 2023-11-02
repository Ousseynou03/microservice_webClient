package com.mybook.mybook.services;

import com.mybook.mybook.entities.Book;
import com.mybook.mybook.models.AuthorResponse;
import com.mybook.mybook.models.BookRequest;
import com.mybook.mybook.models.BookResponse;
import com.mybook.mybook.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    WebClient webClient;
    @Override
    public BookResponse addBook(BookRequest bookRequest) {
        Book newBook = new Book();
        newBook.setTitre(bookRequest.getTitre());
        newBook.setPrix((bookRequest.getPrix()));
        newBook.setAuthorid(bookRequest.getAuthor_id());
        bookRepo.save(newBook);
        return new BookResponse(newBook);
    }

    @Override
    public BookResponse getOneBook(Long id) {
        Book book = bookRepo.getBookById(id);

        AuthorResponse authorResponse = webClient.get()
                .uri("http://localhost:8082/api/author/"+book.getAuthorid())
                .retrieve()
                .bodyToMono(AuthorResponse.class)
                .block();

               return new BookResponse(book, authorResponse);
    }

    @Override
   public List<BookResponse> getAllBooks() {
        List<BookResponse> repBooks = new ArrayList<>();
        List<Book> books = bookRepo.findAll();
        for (Book b:books) {
            repBooks.add(new BookResponse(b));
        }
        return repBooks;
    }

    @Override
    public List<BookResponse> getBooksOfAuthor(Long id) {
        List<BookResponse> repBooks = new ArrayList<>();
        List<Book> books = bookRepo.findByAuthorid(id);
        for (Book b:books) {
            repBooks.add(new BookResponse(b));
        }
        return repBooks;
    }
}
