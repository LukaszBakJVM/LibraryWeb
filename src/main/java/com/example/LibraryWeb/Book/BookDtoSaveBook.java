package com.example.LibraryWeb.Book;

public class BookDtoSaveBook {
    long id;
    private String bookName;
    private String author;
    private String isbn;

    public BookDtoSaveBook() {
    }

    public BookDtoSaveBook(String bookName, String author, String isbn) {
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
    }

    public BookDtoSaveBook(long id, String bookName, String author, String isbn) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
