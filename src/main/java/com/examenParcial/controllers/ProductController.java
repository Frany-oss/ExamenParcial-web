package com.examenParcial.controllers;

import java.util.List;

import com.examenParcial.dtos.ProductDto;
import com.examenParcial.exceptions.WebException;
import com.examenParcial.responses.WebResponse;
import com.examenParcial.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    // --------- get product by Id -----------
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{productId}")
    public WebResponse<ProductDto> getproductById(@PathVariable Long productId) throws WebException {
        return new WebResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", this.productService.findById(productId));
    }

    // -------- get all the products ----------
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public WebResponse<List<ProductDto>> getRestaurants()
            throws WebException{
        return new WebResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                this.productService.findAll());
    }

    // --------- actualizar/guardar producto ----------
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public WebResponse<ProductDto> save(@RequestBody ProductDto productDto) throws WebException {
        productDto.setId(null);
        return new WebResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                this.productService.save(productDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public WebResponse<ProductDto> update(@RequestBody ProductDto productDto) throws WebException {
        return new WebResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                this.productService.save(productDto));
    }

    // ----------- eliminar producto por id ----------------
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{productId}")
    public void deleteById(@PathVariable Long productId) throws WebException {
       this.productService.deleteById(productId);
    }
}
