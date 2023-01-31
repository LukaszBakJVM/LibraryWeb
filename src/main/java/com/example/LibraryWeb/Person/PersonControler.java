package com.example.LibraryWeb.Person;

import com.example.LibraryWeb.Book.BookDto;
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
@RequestMapping("/person")

public class PersonControler {
    private final PersonServices personServices;
    private final ObjectMapper objectMapper;


    public PersonControler(PersonServices personServices, ObjectMapper objectMapper) {
        this.personServices = personServices;
        this.objectMapper = objectMapper;
    }
//Admin i wlasciciel
    @GetMapping("/list/{userName}")
    ResponseEntity<Set<BookDto>> listByUserName(@PathVariable String userName) {
        if (personServices.getBooksByPersonUsername(userName).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personServices.getBooksByPersonUsername(userName));
    }
//Admin
    @GetMapping("/pesel/{pesel}")
    ResponseEntity<PersonDtoSave> findByPesel(@PathVariable int pesel) {
        return personServices.getPersonByPesel(pesel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

//user
    @GetMapping("/{id}")
    ResponseEntity<PersonDto> findById(@PathVariable long id) {
        return personServices.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//All
    @PostMapping
    ResponseEntity<PersonDtoSave> savePerson(@RequestBody PersonDtoSave personSaveDto) {
        PersonDtoSave personDtoSave = personServices.personSave(personSaveDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(personDtoSave.getId())
                .toUri();
        return ResponseEntity.created(uri).body(personDtoSave);
    }
//Admin i własciciel konta
    @PatchMapping("/{id}")
    ResponseEntity<?> updatePersonDtoSave(@PathVariable Long id, @RequestBody JsonMergePatch patch) {
        try {
            PersonDtoSave personDtoSave = personServices.getPersonSaveById(id)
                    .orElseThrow(()->new  PersonNotFoundException("Nie znaleziono osoby o id "+id));
            PersonDtoSave update = applyPatch(personDtoSave, patch);
            personServices.personUpdate(update);

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();


        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.internalServerError().build();
        }


        return ResponseEntity.noContent().build();
    }

    private PersonDtoSave applyPatch(PersonDtoSave personDtoSave, JsonMergePatch patch) throws JsonPatchException, JsonProcessingException {
        JsonNode jsonNode = objectMapper.valueToTree(personDtoSave);
        JsonNode apply = patch.apply(jsonNode);
        return objectMapper.treeToValue(apply,PersonDtoSave.class);

    }
    // admin i wlasciciel konta
    @DeleteMapping("/{id}")
    ResponseEntity<?>delteById(@PathVariable long id){
        personServices.deleteById(id);
       return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/pesel/{pesel}")
    ResponseEntity<?>deletyByPesel(@PathVariable int pesel){
        personServices.deleteByPesel(pesel);
        return ResponseEntity.noContent().build();
    }


}
