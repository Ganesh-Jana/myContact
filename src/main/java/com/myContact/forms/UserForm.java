package com.myContact.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {
  @NotBlank(message = "Username is required")

  private String name;
  @NotBlank(message = "Email is required")
  @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid email format")

  private String email;
  @NotBlank(message = "Password is required")
  @Size(min = 4, message = "minimum 4 characters required")

  private String password;
  @NotBlank(message = "Phone number is required")
  @Size(min = 10, max = 15, message = "minimum 10 digit required")
  private String phone;
}
