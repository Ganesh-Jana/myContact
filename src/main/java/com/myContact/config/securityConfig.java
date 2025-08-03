package com.myContact.config;

import java.security.Security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myContact.services.Impl.SecurityCustomUserDetailsService;

@Configurable
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

  private SecurityCustomUserDetailsService securityCustomUserDetailsService;

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(securityCustomUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;

  }

  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
