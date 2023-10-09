package com.fiap.controllSales.service;

import com.fiap.controllSales.dto.category.CreateCategoryDTO;
import com.fiap.controllSales.dto.category.GetCategoryDTO;
import com.fiap.controllSales.model.Category;
import com.fiap.controllSales.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    @Autowired
    public  CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public GetCategoryDTO createCategory(CreateCategoryDTO request){

        try {
            Category category = new Category();
            category.setId(null);
            category.setName(request.getName());
            category.setActive(true);
            category.setCreation(LocalDateTime.now());
            category.setEnd(null);

            categoryRepository.save(category);

            return  new GetCategoryDTO(
                    category.getId(), category.getName(),category.getCreation()
            );
        }catch (DataAccessException exception){
            throw new RuntimeException("Fail to create new category",exception);
        }
    }

    public GetCategoryDTO getCategory(UUID id){
        try {
             var category =categoryRepository.getReferenceById(id);

             return new GetCategoryDTO(
                     category.getId(), category.getName(),category.getCreation()
             );
        } catch (DataAccessException exception){
          throw new RuntimeException("Fail to get category ",exception);
         }
    }

    public GetCategoryDTO updateCategory(CreateCategoryDTO request){
        try{
            Category category = categoryRepository.getByName(request.getName());

            if(request.getName()!=null){
                category.setName(request.getName());
            }

            categoryRepository.save(category);

            return new GetCategoryDTO(
                    category.getId(), category.getName(),category.getCreation()
            );

        }catch (DataAccessException exception){
            throw new RuntimeException("Fail to update category ",exception);
        }
    }

    public void deleteCategory(UUID id){
        try {
            Category category = categoryRepository.getReferenceById(id);
            category.setEnd(LocalDateTime.now());
            category.setActive(false);
        }catch (DataAccessException exception){
            throw new RuntimeException("Fail to delete category ",exception);
        }
    }


}
