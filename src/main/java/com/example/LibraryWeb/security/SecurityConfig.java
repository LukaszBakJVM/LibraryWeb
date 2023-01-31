package com.example.LibraryWeb.security;




import org.springframework.context.annotation.Configuration;


import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration


public class SecurityConfig {


  /*  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       PathRequest.H2ConsoleRequestMatcher h2ConsoleRequestMatcher = PathRequest.toH2Console();
        http.formLogin().permitAll();

             //   .requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated();
         http.authorizeHttpRequests(requests -> requests.requestMatchers(h2ConsoleRequestMatcher).permitAll()
          .anyRequest().permitAll());



        http.csrf(csrf -> csrf.ignoringRequestMatchers(h2ConsoleRequestMatcher));
        http.headers().frameOptions().sameOrigin();
        return http.build();


    }
  public void configure(WebSecurity web) throws Exception {
      web.ignoring().anyRequest();
  }*/

}