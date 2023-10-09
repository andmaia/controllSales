package com.fiap.controllSales.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int quantity;
    private Long price;
    private boolean active;
    private LocalDateTime creation;
    private  LocalDateTime end;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
