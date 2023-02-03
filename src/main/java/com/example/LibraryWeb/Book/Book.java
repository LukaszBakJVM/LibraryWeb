package com.example.LibraryWeb.Book;

import com.example.LibraryWeb.Person.Person;
import jakarta.persistence.*;

import java.util.Comparator;

@Entity

public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
   private String bookName;
   private String author;
   private String isbn;




    @ManyToOne
    @JoinColumn(name = "person_id")

  private Person person;

    public Book() {
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

   public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }




}
