package com.examenParcial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )

    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
        name = "code",
        updatable = false,
        columnDefinition = "TEXT"
    )
    private String code;

    @Column(
        name = "description",
        updatable = false,
        columnDefinition = "TEXT"
    )
    private String description;
}
