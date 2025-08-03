package com.myContact.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myContact.repositories.userRepo;

@Service
public class SecurityCustomUserDetailsService implements UserDetailsService {

  @Autowired
  private userRepo repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Here you would typically fetch the user from the database
    return repository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

  }

}
