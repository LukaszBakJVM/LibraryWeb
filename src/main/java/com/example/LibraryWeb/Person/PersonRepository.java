package com.example.LibraryWeb.Person;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PersonRepository extends CrudRepository<Person,Long> {
    Set<Person>findById(long id);
}
