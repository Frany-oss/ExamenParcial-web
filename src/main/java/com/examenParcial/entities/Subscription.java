package com.examenParcial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subscriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @SequenceGenerator(
            name="subscription_sequence",
            sequenceName = "subscription_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subscription_sequence"
    )

    @Column(
            name="id"
    )
    private Long id;

    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "VARCHAR(30)"
    )
    private String name;

    @Column(
        name = "description",
        columnDefinition = "VARCHAR(60)"
    )
    private String description;

    @Column(
        name = "price",
        nullable = false
    )
    private Integer price;

    @Column(
        name = "status"
    )
    private Integer status = 1;
}
