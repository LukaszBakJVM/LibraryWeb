package com.example.LibraryWeb.Book;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public  interface BookRepository extends CrudRepository<Book,Long> {

    Optional<Book> findByBookName(String bookName);
    Optional<Book>findByIsbn(String isbn);
    Set<Book> findBooksByPersonUserName(String userName);
    Set<Book>findBooksByPersonId(Long id);
}
