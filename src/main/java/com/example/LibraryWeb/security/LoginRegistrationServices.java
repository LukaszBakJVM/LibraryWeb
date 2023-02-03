package com.example.LibraryWeb.security;


import com.example.LibraryWeb.Person.Person;
import com.example.LibraryWeb.Person.PersonRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginRegistrationServices {
    private final PersonRepository personRepository;
    private final UserRoleRepository userRoleRepository;
    private final PersonDtoLoginMaper personDtoLoginMaper;


    public LoginRegistrationServices(PersonRepository personRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, PersonDtoLoginMaper personDtoLoginMaper) {
        this.personRepository = personRepository;
        this.userRoleRepository = userRoleRepository;

        this.personDtoLoginMaper = personDtoLoginMaper;
    }

    Optional<PersonDtoLogin> findByUserName(String userName) {

        return personRepository.findByUserName(userName)
                .map(personDtoLoginMaper::map);
    }

    PersonRegistrationDto register(PersonRegistrationDto personRegistrationDto) {
        Person p = personDtoLoginMaper.map(personRegistrationDto);
        Person save = personRepository.save(p);
        return personDtoLoginMaper.mapRegister(save);

    }
}