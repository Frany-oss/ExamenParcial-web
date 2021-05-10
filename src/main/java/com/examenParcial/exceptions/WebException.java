package com.examenParcial.exceptions;

import com.examenParcial.dtos.ErrorDtos;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WebException extends Exception {
    private final String code;
    private final int responseCode;
    private final List<ErrorDtos> errorList=new ArrayList<>();

    public WebException(String code,int responseCode,String message){
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public WebException(String code,int responseCode,String message,
                            List<ErrorDtos> errorList){
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorList.addAll(errorList);
    }
}
