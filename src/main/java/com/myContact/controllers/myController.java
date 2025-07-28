package com.myContact.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
@SuppressWarnings("all")
public class myController {
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
  public String signupPage() {
    return "signup";
  }
}
