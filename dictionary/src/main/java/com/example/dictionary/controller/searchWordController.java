package com.example.dictionary.controller;

import com.example.dictionary.entity.Words;
import com.example.dictionary.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/SearchWord")
public class searchWordController {

    @Autowired
    WordService wordService;

    @GetMapping
    public String searchWord(@RequestParam("searchword") String searchWord, Model model) {
        String s = wordService.searchWord(searchWord, model);
        return s;
    }
}
