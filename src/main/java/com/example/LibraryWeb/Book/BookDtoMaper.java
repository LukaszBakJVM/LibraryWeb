package com.example.LibraryWeb.Book;


import org.springframework.stereotype.Service;

@Service

public  class BookDtoMaper {





    public BookDto rentBook(Book book) {
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
        return dto;
    }
}
