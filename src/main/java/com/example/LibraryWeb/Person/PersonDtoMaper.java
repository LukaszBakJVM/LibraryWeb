package com.example.LibraryWeb.Person;

import org.springframework.stereotype.Service;

@Service

public class PersonDtoMaper {
    PersonDto dtoRead(Person person){
        PersonDto personDto =new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        return personDto;
    }

    PersonDtoSave dtoSave(Person person){
        PersonDtoSave dtoSave =new PersonDtoSave();
        dtoSave.setId(person.getId());
        dtoSave.setFirstName(person.getFirstName());
        dtoSave.setLastName(person.getLastName());
        dtoSave.setPesel(person.getPesel());
        return dtoSave;
    }
    Person personSave(PersonDtoSave personDtoSave){
        Person person =new Person();
        person.setId(personDtoSave.getId());
        person.setFirstName(personDtoSave.getFirstName());
        person.setLastName(personDtoSave.getLastName());
        person.setPesel(personDtoSave.getPesel());
        return person;
    }

}
