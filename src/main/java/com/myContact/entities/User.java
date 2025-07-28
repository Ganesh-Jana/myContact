package com.myContact.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  private String userId;
  @Column(name = "user_name", nullable = false)
  private String name;
  @Column(unique = true, nullable = false)
  private String email;
  @Column(nullable = false)
  private String password;
  private String phoneNumber;
  @Column(length = 5000)
  private String about;
  @Column(length = 5000)
  private String imageUrl;

  // information
  private boolean enabled = false;
  private boolean emailVerified = false;
  private boolean phoneVerified = false;

  // self, google, github, facebook
  private Providers provider = Providers.SELF;
  private String providerId;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Contact> contacts = new ArrayList<>();

}
