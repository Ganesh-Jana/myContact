package com.myContact.controllers;

import javax.mail.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myContact.Helpers.MessageType;
import com.myContact.Helpers.message;

// import builder pattern for User entity

import com.myContact.entities.User;
import com.myContact.forms.UserForm;
import com.myContact.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@SuppressWarnings("all")
public class myController {

  @Autowired
  private UserService userService;

  @RequestMapping("/home")
  public String home(Model model) {
    model.addAttribute("message", "Welcome to myContact!");
    System.out.println("Home endpoint accessed");
    return "home";
  }

  @RequestMapping("/about")
  public String aboutPage() {
    return "about";
  }

  @RequestMapping("/service")
  public String servicepage() {
    return "service";
  }

  @RequestMapping("/contact")
  public String contactPage() {
    return "contact";
  }

  @RequestMapping("/login")
  public String loginPage() {
    return "login";
  }

  @RequestMapping("/signup")
  public String signupPage(Model model) {
    UserForm userForm = new UserForm();
    // userForm.setName("Ganesh");
    // userForm.setEmail("janaganesh800@gmail.com");
    // userForm.setPassword("123456");
    // userForm.setPhone("9800436707");
    model.addAttribute("userForm", userForm);
    return "signup";
  }

  // processing register form
  @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
  public String registerPage(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult,
      HttpSession session) {

    // fetch form data
    // validate and save user data
    if (bindingResult.hasErrors()) {
      // if there are validation errors, return to signup page with errors
      session.setAttribute("message", message.builder()
          .content("Validation errors occurred. Please correct them.")
          .type(MessageType.red)
          .build());
      return "signup";
    }

    // User user = User.builder()
    // .name(userForm.getName())
    // .email(userForm.getEmail())
    // .password(userForm.getPassword())
    // .phone(userForm.getPhone())
    // .build();

    User user = new User();
    user.setName(userForm.getName());
    user.setEmail(userForm.getEmail());
    user.setPassword(userForm.getPassword());
    user.setPhone(userForm.getPhone());
    userService.saveUser(user);

    message msg = message.builder()
        .content("User registered successfully!")
        .type(MessageType.green)
        .build();
    session.setAttribute("message", msg);

    // redirect to login page after successful registration
    return "redirect:/signup";
  }
}
