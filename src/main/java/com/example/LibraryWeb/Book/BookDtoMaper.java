package com.example.LibraryWeb.Book;

import com.example.LibraryWeb.Person.Person;
import com.example.LibraryWeb.Person.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public  class BookDtoMaper {
      private final PersonRepository personRepository;

      public BookDtoMaper(PersonRepository personRepository) {
            this.personRepository = personRepository;
      }

      public   BookDto mapBook(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setBookName(book.getBookName());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setPersonId(book.getPerson().getId());
        dto.setPersonFirstName(book.getPerson().getFirstName());
        dto.setPersonLastName(book.getPerson().getLastName());
        return dto;
    }
    public Book book(BookDto bookDto){
        Book book =new Book();
        book.setId(bookDto.id);
        book.setBookName(bookDto.getBookName());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        Person person =personRepository.findById(bookDto.getId()).orElseThrow();
        book.setPerson(person);



        return book;

    }
}
