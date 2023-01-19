package com.example.LibraryWeb.Person;

import org.springframework.stereotype.Service;

@Service

public class PersonDtoMaper {
    PersonDto dto(Person person){
        PersonDto personDto =new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        return personDto;
    }
}
