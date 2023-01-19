package com.example.LibraryWeb.Person;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person,Long> {

    Optional<Person>findPersonByPesel(int id);
}
