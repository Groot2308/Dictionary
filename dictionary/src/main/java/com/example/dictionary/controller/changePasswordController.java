package com.example.dictionary.controller;

import com.example.dictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Changepassword")
public class changePasswordController {

    @Autowired
    UserService userService;

    @PostMapping
    public String changePassword(@RequestParam("oldpass") String oldpass,
                                 @RequestParam("newpass") String newpass,
                                 @RequestParam("confirmpass") String confirmpass,
                                 @RequestParam("id") int id,
                                 Model model) {
        String s = userService.changePassword(oldpass, newpass, confirmpass, id, model);
        return s;
    }

    @GetMapping
    public String changePassword(){
        return "ChangePassword";
    }
}
