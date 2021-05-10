package com.examenParcial.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

import com.examenParcial.dtos.ErrorDtos;

public class InternalServerErrorException extends  WebException {
    public InternalServerErrorException(String code,  String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(String code,  String message,
                                        ErrorDtos data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
