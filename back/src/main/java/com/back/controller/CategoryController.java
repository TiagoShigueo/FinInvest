package com.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.model.Category;
import com.back.repository.CategoryRepository;

@CrossOrigin
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categoriesList = categoryRepository.findAll();
        return ResponseEntity.ok(categoriesList);
    }
}
