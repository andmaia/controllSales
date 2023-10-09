package com.fiap.controllSales.controller;


import com.fiap.controllSales.dto.category.CreateCategoryDTO;
import com.fiap.controllSales.dto.category.GetCategoryDTO;
import com.fiap.controllSales.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    @Transactional
    public ResponseEntity<GetCategoryDTO> create(@RequestBody CreateCategoryDTO createCategoryDTO, UriComponentsBuilder builder){
       GetCategoryDTO categoryResponse = categoryService.createCategory(createCategoryDTO);
       var URI =builder.path("/category/{id}").buildAndExpand(categoryResponse.getId()).toUri();
       return  ResponseEntity.created(URI).body(categoryResponse);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<GetCategoryDTO> read(@PathVariable UUID id){
        GetCategoryDTO categoryResponse = categoryService.getCategory(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<GetCategoryDTO> update(@RequestBody CreateCategoryDTO updateCategoryDTO){
        GetCategoryDTO categoryResponse = categoryService.updateCategory(updateCategoryDTO);
        return  ResponseEntity.ok(categoryResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
