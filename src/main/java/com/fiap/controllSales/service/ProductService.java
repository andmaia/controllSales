package com.fiap.controllSales.service;


import com.fiap.controllSales.dto.product.CreateProductDTO;
import com.fiap.controllSales.dto.product.GetProductDTO;
import com.fiap.controllSales.dto.product.UpdateProductDTO;
import com.fiap.controllSales.model.Category;
import com.fiap.controllSales.model.Product;
import com.fiap.controllSales.repository.CategoryRepository;
import com.fiap.controllSales.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    public GetProductDTO createProduct(CreateProductDTO request){
        try{
            Category category = categoryRepository.getReferenceById(request.getCategory_id());
            Product product = new Product();
            product.setId(null);
            product.setName(request.getName());
            product.setQuantity(request.getQuantity());
            product.setPrice(request.getPrice());
            product.setCreation(LocalDateTime.now());
            product.setActive(true);
            product.setEnd(null);
            product.setCategory(category);
            productRepository.save(product);
            return new GetProductDTO(
                    product.getId(),product.getName(), product.getQuantity(), product.getPrice(), product.getCategory().getId(), product.getCreation()
            );
        }catch (DataAccessException exception){
            throw new RuntimeException("Fail to create product ",exception);
        }
    }

    public GetProductDTO getProduct(UUID id){
        try {
            Product product = productRepository.getReferenceById(id);
            return new GetProductDTO(
                    product.getId(),product.getName(), product.getQuantity(), product.getPrice(), product.getCategory().getId(), product.getCreation()
            );
        }catch (DataAccessException exception){
            throw new RuntimeException("Fal to get product",exception);
        }
    }

    public GetProductDTO updateProduct(UpdateProductDTO request){
        try {
            Product product = productRepository.getByName(request.getName());

            if(request.getName()!=null){
                product.setName(request.getName());
            }
            if(request.getPrice()!=null){
                product.setPrice(request.getPrice());
            }
            if(request.getQuantity()!= product.getQuantity()){
                product.setQuantity(request.getQuantity());
            }
            if(request.getCategory_id()!=null){
                Category category = categoryRepository.getReferenceById(request.getCategory_id());
                product.setCategory(category);
            }

            productRepository.save(product);

            return new GetProductDTO(
                    product.getId(),product.getName(), product.getQuantity(), product.getPrice(), product.getCategory().getId(), product.getCreation()
            );


        }catch (DataAccessException exception){
            throw new RuntimeException("Fail to update product",exception);
        }
    }

    public void deleteProduct(UUID id){
        Product product = productRepository.getReferenceById(id);
        product.setActive(false);
        product.setEnd(LocalDateTime.now());
        productRepository.save(product);
    }

}
