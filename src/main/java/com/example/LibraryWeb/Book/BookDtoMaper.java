package com.example.LibraryWeb.Book;

import org.springframework.stereotype.Service;

@Service

public  class BookDtoMaper {
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
}
