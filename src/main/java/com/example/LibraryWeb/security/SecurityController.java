package com.example.LibraryWeb.security;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller

public class SecurityController {
    private final LoginRegistrationServices loginRegistrationServices;

    public SecurityController(LoginRegistrationServices loginRegistrationServices) {
        this.loginRegistrationServices = loginRegistrationServices;
    }
    @PostMapping("/register")
    ResponseEntity<PersonRegistrationDto> registration(@RequestBody PersonRegistrationDto personRegistrationDto){
        PersonRegistrationDto reg=   loginRegistrationServices.register(personRegistrationDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(reg.getUserName())
                .toUri();
        return ResponseEntity.created(uri).body(reg);
    }

}
