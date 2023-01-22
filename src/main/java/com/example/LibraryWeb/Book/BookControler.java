package com.example.LibraryWeb.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/book")

public class BookControler {
    private final BookServices bookServices;

    public BookControler(BookServices bookServices) {
        this.bookServices = bookServices;
    }
    @GetMapping("/{id}")
    ResponseEntity<BookDto>findById(@PathVariable long id){
        return bookServices.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("bookName/{bookName}")
    ResponseEntity<BookDto>findByBookName(@PathVariable String bookName){
        return bookServices.findByBookName(bookName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookDto>findByIsbn(@PathVariable String isbn){
        return bookServices.getBookByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping()
    ResponseEntity<BookDtoSaveBook>saveBook(@RequestBody BookDtoSaveBook bookDto){
        BookDtoSaveBook bookToSave = bookServices.saveBook(bookDto);
        URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bookToSave.getId())
                .toUri();
        return ResponseEntity.created(uri).body(bookToSave);

    }
   

}
