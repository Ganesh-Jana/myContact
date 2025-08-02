package com.myContact.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myContact.services.UserService;
import com.myContact.Helpers.ResourceNotFoundException;
import com.myContact.entities.User;
import com.myContact.repositories.userRepo;

import java.util.*;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private userRepo userRepository;

  private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public User saveUser(User user) {
    // user id: have to generate
    if (user.getUserId() == null || user.getUserId().isEmpty()) {
      user.setUserId(UUID.randomUUID().toString());
    }
    return userRepository.save(user);
  }

  @Override
  public Optional<User> getUserById(String userId) {
    return userRepository.findById(userId);
  }

  @Override
  public User getUserByEmail(String email) {
    // Logic to get user by email
    return null; // Replace with actual implementation
  }

  @Override
  public Optional<User> updateUser(User user) {
    User user2 = userRepository.findById(user.getUserId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    // Update user2
    user2.setName(user.getName());
    user2.setEmail(user.getEmail());
    user2.setPhone(user.getPhone());
    user2.setPassword(user.getPassword());
    user2.setEnabled(user.isEnabled());
    user2.setEmailVerified(user.isEmailVerified());
    user2.setPhoneVerified(user.isPhoneVerified());
    user2.setProvider(user.getProvider());
    user2.setProviderId(user.getProviderId());

    return Optional.ofNullable(userRepository.save(user2));
  }

  @Override
  public void deleteUser(String userId) {
    User user2 = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    userRepository.delete(user2);
  }

  @Override
  public boolean existsById(String userId) {
    User user2 = userRepository.findById(userId).orElse(null);
    return user2 != null ? true : false; // Check if user exists by ID
  }

  @Override
  public boolean existsByEmail(String email) {
    User user = userRepository.findByEmail(email).orElse(null);
    return user != null ? true : false;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

}
