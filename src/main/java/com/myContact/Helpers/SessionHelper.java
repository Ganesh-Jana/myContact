package com.myContact.Helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {

  public static void removeMessage() {
    try {
      ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
      if (attrs != null) {
        HttpSession session = attrs.getRequest().getSession();
        session.removeAttribute("message");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
