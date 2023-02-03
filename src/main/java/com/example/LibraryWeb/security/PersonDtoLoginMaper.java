package com.example.LibraryWeb.security;

import com.example.LibraryWeb.Person.Person;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service

public class PersonDtoLoginMaper {
    private final PasswordEncoder passwordEncoder;

    public PersonDtoLoginMaper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    PersonDtoLogin map(Person person) {
        PersonDtoLogin dto = new PersonDtoLogin();
        dto.setUserName(person.getUserName());
        dto.setPassword(person.getPassword());
        dto.setUserRoles(
                person.getRola()
                        .stream().map(UserRole::getRole)
                        .collect(Collectors.toSet()));
        return dto;


    }

    Person map(PersonRegistrationDto personRegistrationDto) {
        Person person = new Person();

        person.setUserName(personRegistrationDto.getUserName());
        person.setEmail(personRegistrationDto.getEmail());
        person.setFirstName(personRegistrationDto.getFirstName());
        person.setLastName(personRegistrationDto.getLastName());
        person.setPesel(personRegistrationDto.getPesel());
        String encode = passwordEncoder.encode(personRegistrationDto.getPassword());
        person.setPassword(encode);
        return person;
    }


    PersonRegistrationDto mapRegister(Person person) {
        PersonRegistrationDto dto = new PersonRegistrationDto();

        dto.setUserName(person.getUserName());
        dto.setEmail(person.getEmail());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setPesel(person.getPesel());
        dto.setPassword(person.getPassword());

        return dto;

    }
}
