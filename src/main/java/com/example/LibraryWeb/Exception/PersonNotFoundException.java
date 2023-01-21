package com.example.LibraryWeb.Exception;

public class PersonNotFoundException extends Exception{
    public PersonNotFoundException(String message) {
        super("Person not Found");
    }
}
