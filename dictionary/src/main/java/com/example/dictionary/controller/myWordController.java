package com.example.dictionary.controller;

import com.example.dictionary.service.SearchHistoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MyWord")
public class myWordController {

     @Autowired
     private SearchHistoryService searchHistoryService;

    @GetMapping
    public String getMyWord(HttpSession session, HttpServletRequest request){
         String s = searchHistoryService.getMyWord(session, request);
         return s;
    }
}
