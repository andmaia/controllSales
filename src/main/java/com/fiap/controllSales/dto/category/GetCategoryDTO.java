package com.fiap.controllSales.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryDTO {
    private UUID id;
    private String name;
    private LocalDateTime creation;
}
