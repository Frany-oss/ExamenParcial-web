package com.examenParcial.services;

import java.util.List;

import com.examenParcial.dtos.ProductDto;
import com.examenParcial.exceptions.WebException;


public interface ProductService {
    
    ProductDto findById(Long id) throws WebException;
    List<ProductDto> findAll() throws WebException;
    ProductDto save(ProductDto productDto) throws WebException;
    void deleteById(Long id) throws WebException;
}
