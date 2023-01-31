package com.example.LibraryWeb.Person;

import com.example.LibraryWeb.Book.Book;
import jakarta.persistence.*;


import java.util.Set;
import java.util.TreeSet;

@Entity

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //dostep User
    private String userName;
    private String email;
// dostemp Admin -vice
    private String firstName;
    private String lastName;
    private int pesel;
    //hash nie dostepe
    private String password;
   // @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "wyporzyczone"
            ,joinColumns = @JoinColumn(name = "wyporzyczajacy",referencedColumnName = "lastName")
            ,inverseJoinColumns = @JoinColumn(name ="ksiazki",referencedColumnName = "bookName"))



    private Set<Book>bookSet =new TreeSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
