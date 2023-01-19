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
    Optional<PersonDto>getPersonByPesel(int id){
        return personRepository.findPersonByPesel(id)
                .map(personDtoMaper::dto);
    }

    Set<BookDto>getBooksByPersonId(long id){
        return   bookRepository.findBooksByPersonId(id)
                .stream().map(bookDtoMaper::mapBook) .collect(Collectors.toSet());

    }
    Optional<PersonDto>getPersonById(long id){
        return personRepository.findById(id)
                .map(personDtoMaper::dto);
    }
    PersonDtoSave personSave(PersonDtoSave personDtoSave){
        Person personToSave = personDtoMaper.person(personDtoSave);
        Person save = personRepository.save(personToSave);
        return personDtoMaper.dtoSave(save);
    }
}