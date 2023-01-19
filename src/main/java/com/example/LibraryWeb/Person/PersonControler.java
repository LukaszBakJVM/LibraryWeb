package com.example.LibraryWeb.Person;

import com.example.LibraryWeb.Book.BookDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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
    @PostMapping
ResponseEntity<PersonDtoSave>savePerson(@RequestBody PersonDtoSave personDto){
        PersonDtoSave personDtoSave = personServices.personSave(personDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(personDtoSave.getId())
            .toUri();
   return ResponseEntity.created(uri).body(personDtoSave);
}


}
