package com.example.LibraryWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class TestBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBookApplication.class, args);

    }
@Bean
Scanner scanner (){
    return new Scanner(System.in);
        }
    }





