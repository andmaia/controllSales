package com.fiap.controllSales.controller;


import com.fiap.controllSales.dto.category.CreateCategoryDTO;
import com.fiap.controllSales.dto.category.GetCategoryDTO;
import com.fiap.controllSales.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    @Transactional
    public ResponseEntity<GetCategoryDTO> create(@RequestBody CreateCategoryDTO createCategoryDTO){
        categoryService.createCategory(createCategoryDTO);
        return new ResponseEntity<GetCategoryDTO>(HttpStatus.CREATED);
    }

}
