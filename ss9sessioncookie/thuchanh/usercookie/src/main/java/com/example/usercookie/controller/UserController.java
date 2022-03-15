package com.example.usercookie.controller;

import com.example.usercookie.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User innitUser() {
        return new User();
    }

    @GetMapping("/login")
    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
//        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", setUser);
        return "/login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@SessionAttribute("user") User user, Model model, HttpServletResponse response) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
//            if (user.getEmail()!=null)
            Cookie cookie = new Cookie("setUser", user.getEmail());
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
//            Cookie[] cookies = request.getCookies();
//            for (Cookie ck : cookies) {
//            if (cookie.getName().equals(user.getEmail())) {
//                model.addAttribute("cookieValue", cookie);
//
//            } else {
//                cookie.setValue("");
//                model.addAttribute("cookieValue", cookie);
//
//            }
            model.addAttribute("message", "login success. welcome ");
        }
        else {
//            user.setEmail("");
//            Cookie cookie = new Cookie("setUser", user.getEmail());
//            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");

        }
        return "redirect:/login";
    }


}
