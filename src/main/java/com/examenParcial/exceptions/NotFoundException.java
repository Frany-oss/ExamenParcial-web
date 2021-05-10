package com.examenParcial.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

import com.examenParcial.dtos.ErrorDtos;

public class NotFoundException extends WebException{
    public NotFoundException(String code,String message){
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(String code, String message, ErrorDtos data){
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
}
