package com.example.LibraryWeb.Person;

import org.springframework.stereotype.Service;

@Service

public class PersonDtoMaper {
    PersonDto dtoRead(Person person){
        PersonDto personDto =new PersonDto();
        personDto.setId(person.getId());
        personDto.setUserName(person.getUserName());
        personDto.setEmail(person.getEmail());

        return personDto;
    }

    PersonDtoSave dtoSave(Person person){
        PersonDtoSave dtoSave =new PersonDtoSave();
        dtoSave.setId(person.getId());
        dtoSave.setUserName(person.getUserName());
        dtoSave.setEmail(person.getEmail());
        dtoSave.setFirstName(person.getFirstName());
        dtoSave.setLastName(person.getLastName());
        dtoSave.setPesel(person.getPesel());
        dtoSave.setPassword(person.getPassword());
        return dtoSave;
    }
    Person personSave(PersonDtoSave personDtoSave){
        Person person =new Person();
        person.setId(personDtoSave.getId());
        person.setUserName(personDtoSave.getUserName());
        person.setEmail(personDtoSave.getEmail());
        person.setFirstName(personDtoSave.getFirstName());
        person.setLastName(personDtoSave.getLastName());
        person.setPesel(personDtoSave.getPesel());
        person.setPassword(personDtoSave.getPassword());
        return person;
    }

}
