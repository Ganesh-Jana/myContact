package com.myContact.config;

import java.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.myContact.services.Impl.SecurityCustomUserDetailsService;

@Configuration
public class securityConfig {

  // user create and login using java code in memory service
  // @Bean
  // public UserDetailsService userDetailsService() {
  // UserDetails user1 = User
  // .withDefaultPasswordEncoder()
  // .username("user")
  // .password("password")
  // .roles("USER")
  // .build();

  // return new InMemoryUserDetailsManager(user1);
  // }

  @Autowired
  private SecurityCustomUserDetailsService securityCustomUserDetailsService;

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;

  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> {
          auth
              .requestMatchers("/user/**").authenticated()
              .anyRequest().permitAll();
        });
    // .formLogin(form -> {
    // form
    // .loginPage("/login")
    // .loginProcessingUrl("/user/login")
    // .defaultSuccessUrl("/home", true)
    // .permitAll();
    // });
    http.formLogin(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
