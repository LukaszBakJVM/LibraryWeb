package com.example.LibraryWeb.Book;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServices {
    final private BookRepository bookRepository;
    private final BookDtoMaper bookDtoMaper;

    public BookServices(BookRepository bookRepository, BookDtoMaper bookDtoMaper) {
        this.bookRepository = bookRepository;
        this.bookDtoMaper = bookDtoMaper;
    }

    Optional<BookDto> getBookById(long id) {
        return bookRepository.findById(id)
                .map(bookDtoMaper::mapBook);
    }

    Optional<BookDto> findByBookName(String name) {
        return bookRepository.findByBookName(name)
                .map(bookDtoMaper::mapBook);
    }

    Optional<BookDto> getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(bookDtoMaper::mapBook);
    }

    public BookDtoSaveBook saveBook(BookDtoSaveBook bookDto) {
        Book book = bookDtoMaper.book(bookDto);
        Book save = bookRepository.save(book);
        return bookDtoMaper.saveBook(save);

    }

    public void rentbook(BookDto bookDto) {
        Book book = bookDtoMaper.rentBook(bookDto);

        Optional<Book> byId = bookRepository.findById(book.getId());

        if (byId.isPresent()) {
            Book b = bookDtoMaper.rentBook(bookDto);

            bookRepository.save(b);
        }

    }
}