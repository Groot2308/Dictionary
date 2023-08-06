package com.example.dictionary.controller;

import com.example.dictionary.entity.Category;
import com.example.dictionary.repository.CategoryRepository;
import com.example.dictionary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class homeController {
//    @Autowired
//    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllCategory(Model model){
        List<Category> categoryList = categoryService.findAllCategory();
       model.addAttribute("clist", categoryList);
       return "HomePage";
    }
}
