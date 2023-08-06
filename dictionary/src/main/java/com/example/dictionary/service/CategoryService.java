package com.example.dictionary.service;

import com.example.dictionary.entity.Category;
import com.example.dictionary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAllCategory(){
      List<Category> categoryList =  categoryRepository.findAll();
      return categoryList;
    }
}
