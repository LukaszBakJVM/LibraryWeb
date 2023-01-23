package com.example.LibraryWeb.Book;


import com.example.LibraryWeb.Exception.PersonNotFoundException;
import com.example.LibraryWeb.Person.Person;
import com.example.LibraryWeb.Person.PersonRepository;
import org.springframework.stereotype.Service;



@Service

public  class BookDtoMaper {
    private final PersonRepository personRepository;

    public BookDtoMaper(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Book rentBook(BookDto book) {
        Book dto = new Book();
        dto.setId(book.getId());
        dto.setBookName(book.getBookName());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        Person person = personRepository.findById(dto.getPerson().getId())
                .orElseThrow(()->new  PersonNotFoundException("Nie znaleziono osoby o podanym  id "));
        dto.setPerson(person);
        return dto;
    }

    public Book book(BookDtoSaveBook bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setBookName(bookDto.getBookName());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        return book;

    }

    public BookDtoSaveBook saveBook(Book book) {
        BookDtoSaveBook dto = new BookDtoSaveBook();
        dto.setId(book.getId());
        dto.setBookName(book.getBookName());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());

        return dto;
    }
    public BookDto mapBook(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setBookName(book.getBookName());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setPersonId(book.getPerson().getId());
        dto.setPersonFirstName(book.getPerson().getFirstName());
        dto.setPersonLastName(book.getPerson().getLastName());
        dto.setPersonPesel(book.getPerson().getPesel());
        return dto;
    }
}
