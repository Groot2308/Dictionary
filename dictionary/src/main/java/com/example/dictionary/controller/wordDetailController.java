package com.example.dictionary.controller;

import com.example.dictionary.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/WordDetail")
public class wordDetailController {

    @Autowired
    WordService wordService;
    @GetMapping
    public String getWordById(@RequestParam("wid") int wid, Model model){
         String s = wordService.getWordId(wid, model);
         return s;
    }
}
