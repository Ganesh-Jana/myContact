package com.myContact.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {
  // user Dashboard page
  @RequestMapping("/dashboard")
  public String userDashboard() {
    return "user/dashboard";
  }

  // user profile page
  @RequestMapping("/profile")
  public String userProfile() {
    return "user/profile";
  }

  // user contact view page

  // contact delete page

  // contact edit page

}
