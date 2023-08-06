package com.example.dictionary.service;

import com.example.dictionary.entity.Role;
import com.example.dictionary.entity.User;
import com.example.dictionary.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User findByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

    public String findByEmailAndPassword(String email, String password, HttpSession session, Model model){

        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            session.setAttribute("account", user);
            return "redirect:/";
        } else {
            String mess = "Email or password wrong!";
            model.addAttribute("mess", mess);
            return "login";
        }
    }

    public String register(User user, String confirmPassword, Model model){
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            model.addAttribute("mess", "Email already exists in the system!");
            return "Register";
        }

        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("mess", "Confirm Password is not correct");
            return "Register";
        }
        // Lưu user vào cơ sở dữ liệu
        user.setRole(new Role(2));
        userRepository.save(user);
        return "redirect:/Login";
    }

    public void save(User user){
        userRepository.save(user);
    }

    public String changePassword(String oldPass, String newPass, String confirmPass,
                                 int id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null || !user.getPassword().equals(oldPass)) {
            model.addAttribute("mess", "Old password incorrect");
        } else if (!newPass.equals(confirmPass)) {
            model.addAttribute("mess", "Confirm password incorrect");
        } else {
            user.setPassword(newPass);
            userRepository.save(user);
            model.addAttribute("noti", "Change password successful");
        }
        return "ChangePassword";
    }

}
