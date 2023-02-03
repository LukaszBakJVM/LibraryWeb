package com.example.LibraryWeb.Person;


import com.example.LibraryWeb.Book.Book;
import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person,Long> {
    Optional<Person>findByUserName(String userName);


    Optional<Person>findPersonByPesel(int id);
    @Transactional
    Optional<Person>deleteByPesel(int pesel);
    Optional<Person>deletePersonByUserName(String userName);




}
