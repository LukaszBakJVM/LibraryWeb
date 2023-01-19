package com.example.LibraryWeb.Person;

import com.example.LibraryWeb.Book.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Set;

@RestController
@RequestMapping("/person")

public class PersonControler {
    private final PersonServices personServices;

    public PersonControler(PersonServices personServices) {
        this.personServices = personServices;
    }
   @GetMapping("/{id}")
   ResponseEntity<Set<BookDto>> listById(@PathVariable long id){
        if (personServices.getBooksByPersonId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personServices.getBooksByPersonId(id));
    }



}
