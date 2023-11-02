package com.mybook.mybook.repositories;

import com.mybook.mybook.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Long> {
    Book getBookById(Long id);
    List<Book> findByAuthorid(Long id); // id de l'auteur
}
