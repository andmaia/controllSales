package com.fiap.controllSales.repository;

import com.fiap.controllSales.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository  extends JpaRepository<Product, UUID> {
    Product getByName(String name);
}
