package com.examenParcial.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.examenParcial.dtos.ProductDto;
import com.examenParcial.entities.Product;
import com.examenParcial.exceptions.NotFoundException;
import com.examenParcial.exceptions.WebException;
import com.examenParcial.repositorys.ProductRepository;
import com.examenParcial.services.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    // ----------- encontrar por ID ------------
    @Override
    public ProductDto findById(Long id) throws WebException{
        return modelMapper.map(findEntity(id), ProductDto.class);
    }

    private Object findEntity(Long id) throws WebException{
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("NOTFOUND-404","_NOTFOUND-404"));
    }

    // ------------- encontrar todos -------------
    @Override
    public List<ProductDto> findAll() {
        List<Product> productEntity = productRepository.findAll();
        return productEntity.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }

    // ---------- guardar y actualizar -----------
    public ProductDto save(ProductDto productDto) throws WebException {

        Product product = this.dtoEntity(productDto);
        Product saveProduct = this.productRepository.save(product);

        return new ProductDto(saveProduct);
    }

    private Product dtoEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    // ------------- eliminar por ID --------------
    @Override
    public void deleteById(Long id) throws WebException {
        this.productRepository.deleteById(id);
        
    }
    
}
