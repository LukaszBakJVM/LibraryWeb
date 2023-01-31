package com.example.LibraryWeb.security;

import com.example.LibraryWeb.Person.Person;
import jakarta.persistence.*;

import java.util.HashSet;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity

public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String role;
    private String description;
    @ManyToMany

    @JoinTable (name = "Rola"
            ,joinColumns = @JoinColumn(name = "rola",referencedColumnName = "role")
            ,inverseJoinColumns = @JoinColumn(name ="nazwa_uzytkownika",referencedColumnName = "userName"))
    private Set<Person>personRole=new LinkedHashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Person> getPersonRole() {
        return personRole;
    }

    public void setPersonRole(Set<Person> personRole) {
        this.personRole = personRole;
    }
}
