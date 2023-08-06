package com.example.dictionary.controller;


import com.example.dictionary.entity.Words;
import com.example.dictionary.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/LearnWord")
public class learnWordController {
@Autowired
    WordRepository wordRepository;

    @GetMapping
    public String getWordById(@RequestParam("cid") String cid, Model model) {
        List<Words> words = wordRepository.findByCategoryId(Integer.parseInt(cid));
        model.addAttribute("words", words);
        return "WordList";
    }

}
