package com.fiap.controllSales.controller;


import com.fiap.controllSales.dto.category.CreateCategoryDTO;
import com.fiap.controllSales.dto.category.GetCategoryDTO;
import com.fiap.controllSales.dto.category.UpdateCategoryDTO;
import com.fiap.controllSales.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    @Transactional
    public String create(@ModelAttribute CreateCategoryDTO createCategoryDTO, Model model) {
        GetCategoryDTO categoryResponse = categoryService.createCategory(createCategoryDTO);

        // Atualize a lista de categorias no modelo
        Page<GetCategoryDTO> categories = categoryService.getAllCategories(PageRequest.of(0, 10)); // Ajuste a paginação conforme necessário
        model.addAttribute("categories", categories);

        // Redirecione de volta à página com a lista atualizada
        return "category/Category";
    }

    @GetMapping("/{id}")
    public  ResponseEntity<GetCategoryDTO> read(@PathVariable UUID id){
        GetCategoryDTO categoryResponse = categoryService.getCategory(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping("/iniciar")
    public String form(@RequestParam(value = "updateCategories", required = false) String updateCategories, Model model) {
        if ("true".equals(updateCategories)) {
            // Chamando a função de paginação para atualizar a lista de categorias
            Page<GetCategoryDTO> categories = categoryService.getAllCategories(PageRequest.of(0, 10)); // Altere PageRequest conforme necessário
            model.addAttribute("categories", categories);
        }

        return "category/Category";
    }


    @PutMapping
    @Transactional
    public ResponseEntity<GetCategoryDTO> update(@RequestBody UpdateCategoryDTO updateCategoryDTO){
        GetCategoryDTO categoryResponse = categoryService.updateCategory(updateCategoryDTO);
        return  ResponseEntity.ok(categoryResponse);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/cadastro")
    public String form(){
        return "category/Category";
    }



}
