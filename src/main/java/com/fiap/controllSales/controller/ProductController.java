package com.fiap.controllSales.controller;

import com.fiap.controllSales.dto.category.CreateCategoryDTO;
import com.fiap.controllSales.dto.category.GetCategoryDTO;
import com.fiap.controllSales.dto.product.CreateProductDTO;
import com.fiap.controllSales.service.CategoryService;
import com.fiap.controllSales.service.ProductService;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    @Transactional
    public ResponseEntity<CreateProductDTO> create(@RequestBody CreateProductDTO createProductDTO) {
         productService.createProduct(createProductDTO);
        return new ResponseEntity<CreateProductDTO>(HttpStatus.CREATED);
    }
}
