package com.fiap.controllSales.dto.product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDTO {
    private String name;
    private int quantity;
    private Long price;
    private UUID category_id;
}
