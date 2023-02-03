package com.example.LibraryWeb.security;




import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration


public class SecurityConfig {






    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

      PathRequest.H2ConsoleRequestMatcher h2ConsoleRequestMatcher = PathRequest.toH2Console();
        http.formLogin().permitAll();

        http.authorizeHttpRequests(r->r.requestMatchers(h2ConsoleRequestMatcher).permitAll())
                .authorizeHttpRequests(r->r.requestMatchers("/person/{}").permitAll()
                .requestMatchers("/register").permitAll()
                .anyRequest().authenticated());







        http.csrf(csrf -> csrf.ignoringRequestMatchers(h2ConsoleRequestMatcher));
        http.csrf(c->c.ignoringRequestMatchers("/register"));
        http.headers().frameOptions().sameOrigin();
        return http.build();


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

  }

