package com.example.dictionary.service;

import com.example.dictionary.entity.Words;
import com.example.dictionary.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class WordService {

@Autowired
    WordRepository wordRepository;

    public String searchWord(String word, Model model) {
        List<Words> wordList = wordRepository.findByWord(word);
        if (wordList.isEmpty()) {
            model.addAttribute("mess", "từ cần tìm kiếm không tồn tại");
        } else {
            model.addAttribute("words", wordList);
        }
        return "WordList";
    }

    public String getWordId(int wid, Model model){
        Words words = wordRepository.findById(wid);
        model.addAttribute("w", words);
        return "WordDetail";
    }

}
