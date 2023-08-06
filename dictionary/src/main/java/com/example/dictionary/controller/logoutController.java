package com.example.dictionary.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Logout")
public class logoutController {

    @GetMapping
    public String logout(HttpSession session){
        session.invalidate();
       return "redirect:/";
    }
}
