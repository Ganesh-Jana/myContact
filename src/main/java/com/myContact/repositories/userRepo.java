package com.myContact.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myContact.entities.User;

@Repository
public interface userRepo extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);
}
