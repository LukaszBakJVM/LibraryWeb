package com.example.LibraryWeb.Person;



import com.example.LibraryWeb.Book.BookDto;
import com.example.LibraryWeb.Book.BookDtoMaper;
import com.example.LibraryWeb.Book.BookRepository;

import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class PersonServices {
    private final PersonRepository personRepository;
    private final PersonDtoMaper personDtoMaper;
    private final BookRepository bookRepository;
    private final BookDtoMaper bookDtoMaper;


    public PersonServices(PersonRepository personRepository, PersonDtoMaper personDtoMaper,
                          BookRepository bookRepository, BookDtoMaper bookDtoMaper) {
        this.personRepository = personRepository;
        this.personDtoMaper = personDtoMaper;
        this.bookRepository = bookRepository;
        this.bookDtoMaper = bookDtoMaper;
    }

    Optional<PersonDtoSave> getPersonByPesel(int id) {
        return personRepository.findPersonByPesel(id)
                .map(personDtoMaper::dtoSave);
    }

    Set<BookDto> getBooksByPersonUsername(String userName) {
        return bookRepository.findBooksByPersonUserName(userName)
                .stream().map(bookDtoMaper::mapBook).collect(Collectors.toSet());

    }

    Optional<PersonDto> getPersonById(long id) {
        return personRepository.findById(id)
                .map(personDtoMaper::dtoRead);
    }

    PersonDtoSave personSave(PersonDtoSave personDtoSave) {
        Person personToSave = personDtoMaper.personSave(personDtoSave);
        Person save = personRepository.save(personToSave);
        return personDtoMaper.dtoSave(save);
    }

public    void personUpdate(PersonDtoSave personDtoSave) {
     Person p = personDtoMaper.personSave(personDtoSave);
     Optional<Person> byId = personRepository.findById(p.getId());

     if (byId.isPresent()) {
         Person person = personDtoMaper.personSave(personDtoSave);
         personRepository.save(person);
     }
 }

   Optional<PersonDtoSave> getPersonSaveById(long id) {
        return personRepository.findById(id)
                .map(personDtoMaper::dtoSave);
    }
    public  void deleteById( long id){
        personRepository.deleteById(id);




    }
    public void  deleteByPesel(int pesel){
        personRepository.deleteByPesel(pesel);
    }
    public void  deleteByUserName(String userName){
        personRepository.deletePersonByUserName(userName);
    }





}