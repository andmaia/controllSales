package com.fiap.controllSales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @NotBlank(message = "{product.name.blank}")
    private String name;

    @Min(1) @Max(100)
    private int quantity;

    @Min(1) @Max(9000)
    private Long price;
    private boolean active;
    private LocalDateTime creation;
    private  LocalDateTime end;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
