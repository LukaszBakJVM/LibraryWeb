package com.example.LibraryWeb.security;


import java.util.Set;

public class PersonDtoLogin {
    private  String userName;
    private   String password;
    private  Set<String>userRoles;

    public PersonDtoLogin() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getUserRoles() {
        return userRoles;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRoles(Set<String> userRoles) {
        this.userRoles = userRoles;
    }
}


