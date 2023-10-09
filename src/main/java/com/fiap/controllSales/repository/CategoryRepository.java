package com.fiap.controllSales.repository;

import com.fiap.controllSales.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category getByName(String name);
}
