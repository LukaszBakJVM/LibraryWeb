package com.example.LibraryWeb.security;


import com.example.LibraryWeb.Exception.PersonNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Login implements UserDetailsService {
    private final LoginRegistrationServices loginRegistrationServices;

    public Login(LoginRegistrationServices loginRegistrationServices) {
        this.loginRegistrationServices = loginRegistrationServices;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginRegistrationServices.findByUserName(username)
                .map(this::createPersonDetails)
                .orElseThrow(()-> new  PersonNotFoundException("Nie znaleziono osobt o nazwie "+username));
    }

    private UserDetails createPersonDetails(PersonDtoLogin credentials) {
        return User.builder()
                .username(credentials.getUserName())
                .password(credentials.getPassword())
                .roles(credentials.getUserRoles().toArray(String[]::new))
                .build();
    }
}