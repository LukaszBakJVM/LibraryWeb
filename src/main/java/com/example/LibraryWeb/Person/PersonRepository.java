package com.example.LibraryWeb.Person;


import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person,Long> {


    Optional<Person>findPersonByPesel(int id);
    @Transactional
    Optional<Person>deleteByPesel(int pesel);
    Optional<Person>deletePersonByUserName(String userName);



}
