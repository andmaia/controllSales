package com.fiap.controllSales.controller;

import com.fiap.controllSales.dto.product.CreateProductDTO;
import com.fiap.controllSales.dto.product.GetProductDTO;
import com.fiap.controllSales.dto.product.UpdateProductDTO;
import com.fiap.controllSales.model.Product;
import com.fiap.controllSales.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    @Transactional
    public ResponseEntity<GetProductDTO> create(@RequestBody CreateProductDTO createProductDTO, UriComponentsBuilder builder) {
        GetProductDTO productResponse = productService.createProduct(createProductDTO);
        var URI = builder.path("/product/{id}").buildAndExpand(productResponse.getId()).toUri();
        return ResponseEntity.created(URI).body(productResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductDTO> read(@PathVariable UUID id){
        GetProductDTO productResponse = productService.getProduct(id);
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<GetProductDTO> update(@RequestBody UpdateProductDTO updateProductDTO){
        GetProductDTO productResponse = productService.updateProduct(updateProductDTO);
        return ResponseEntity.ok(productResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cadastro")
    public String form(){
        return "products/Products";
    }

}
