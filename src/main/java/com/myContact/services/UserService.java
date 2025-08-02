package com.myContact.services;

import java.util.List;
import java.util.Optional;

import com.myContact.entities.User;

public interface UserService {

  User saveUser(User user);

  Optional<User> getUserById(String userId);

  User getUserByEmail(String email);

  Optional<User> updateUser(User user);

  void deleteUser(String userId);

  boolean existsById(String userId);

  boolean existsByEmail(String email);

  List<User> getAllUsers();
}
