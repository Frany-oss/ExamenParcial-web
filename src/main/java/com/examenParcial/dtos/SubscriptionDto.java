package com.examenParcial.dtos;

import com.examenParcial.entities.Subscription;
import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private Integer status = 1;

    public SubscriptionDto(Subscription product) {
        BeanUtils.copyProperties(product, this);
    }
}
