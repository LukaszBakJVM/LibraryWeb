package com.example.LibraryWeb.Book;

import com.example.LibraryWeb.Exception.PersonNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Set;


@RestController
@RequestMapping("/book")

public class BookControler {
    private final BookServices bookServices;
    private final ObjectMapper objectMapper;

    public BookControler(BookServices bookServices, ObjectMapper objectMapper) {
        this.bookServices = bookServices;
        this.objectMapper = objectMapper;
    }

@GetMapping("/available")
    ResponseEntity<Set<BookDtoSaveBook>> available() {
        return ResponseEntity.ok(bookServices.allAvailableBooks());
    }
    @GetMapping("/{id}")
    ResponseEntity<BookDto>findById(@PathVariable long id){
        return bookServices.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //Admin
    @GetMapping("/bookName/{bookName}")
    ResponseEntity<BookDto>findByBookName(@PathVariable String bookName){
        return bookServices.findByBookName(bookName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //Admin
    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookDto>findByIsbn(@PathVariable String isbn){
        return bookServices.getBookByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //Admin
    @PostMapping()
    ResponseEntity<BookDtoSaveBook>saveBook(@RequestBody BookDtoSaveBook bookDto){
        BookDtoSaveBook bookToSave = bookServices.saveBook(bookDto);
        URI uri =ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bookToSave.getId())
                .toUri();
        return ResponseEntity.created(uri).body(bookToSave);

    }
    //All
    @PatchMapping("/{id}")
    ResponseEntity<?> rentBook(@PathVariable Long id, @RequestBody JsonMergePatch patch) {
        try {
            BookDto bookDto = bookServices.getBookById(id)
                    .orElseThrow(() -> new PersonNotFoundException("Nie znaleziono osoby o id " + id));
            BookDto update = applyPatch(bookDto, patch);
            bookServices.rentBook(update);

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();


        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.internalServerError().build();
        }


        return ResponseEntity.noContent().build();
    }

    private BookDto applyPatch(BookDto bookDto, JsonMergePatch patch) throws JsonPatchException, JsonProcessingException {
        JsonNode jsonNode = objectMapper.valueToTree(bookDto);
        JsonNode apply = patch.apply(jsonNode);
        return objectMapper.treeToValue(apply,BookDto.class);

    }
   

}
