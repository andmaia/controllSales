package com.fiap.controllSales.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProductDTO {
    private UUID id;
    private String name;
    private int quantity;
    private Long price;
    private  UUID category_id;
    private LocalDateTime creation;

}
