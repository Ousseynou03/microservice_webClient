package com.mybook.mybook.services;

import com.mybook.mybook.models.BookRequest;
import com.mybook.mybook.models.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse addBook(BookRequest bookRequest);
    BookResponse getOneBook(Long id);
    List<BookResponse> getAllBooks();
    List<BookResponse> getBooksOfAuthor(Long id);

}
