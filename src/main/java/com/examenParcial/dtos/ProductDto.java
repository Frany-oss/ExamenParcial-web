package com.examenParcial.dtos;

import com.examenParcial.entities.Product;
import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String code;
    private String description;

    public ProductDto(Product product) {
        BeanUtils.copyProperties(product, this);
    }
}
