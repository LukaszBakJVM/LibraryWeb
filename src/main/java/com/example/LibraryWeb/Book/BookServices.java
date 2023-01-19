package com.example.LibraryWeb.Book;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServices {
    final private BookRepository bookRepository;
    private final BookDtoMaper bookDtoMaper;

    public BookServices(BookRepository bookRepository, BookDtoMaper bookDtoMaper) {
        this.bookRepository = bookRepository;
        this.bookDtoMaper = bookDtoMaper;
    }

    Optional<BookDto>findByBookName(String name) {
       return bookRepository.findByBookName(name)
                .map(bookDtoMaper::mapBook);
    }
    Optional<BookDto>getByIsbn(String isbn){
      return   bookRepository.findByIsbn(isbn)
                .map(bookDtoMaper::mapBook);
    }
    Set<BookDto>getBooksByPersonId(long id){
      return   bookRepository.findBooksByPersonId(id)
              .stream().map(bookDtoMaper::mapBook)
              .collect(Collectors.toSet());
    }
}
