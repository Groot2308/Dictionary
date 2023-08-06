package com.example.dictionary.controller;

import com.example.dictionary.entity.Role;
import com.example.dictionary.entity.User;
import com.example.dictionary.repository.UserRepository;
import com.example.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Register")
public class registerController {
//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @GetMapping
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "Register";
    }

    @PostMapping
    public String register(@ModelAttribute("user") User user, @RequestParam("confirmpassword") String confirmpassword,
                           Model model) {
        String register = userService.register(user, confirmpassword, model);
        return register;
    }
}
