package com.example.LibraryWeb.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/book")

public class BookControler {
    private final BookServices bookServices;

    public BookControler(BookServices bookServices) {
        this.bookServices = bookServices;
    }
    @GetMapping("/{bookName}")
    ResponseEntity<BookDto>findByBookName(@PathVariable String bookName){
        return bookServices.findByBookName(bookName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookDto>findByIsbn(@PathVariable String isbn){
        return bookServices.getByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   

}
