package com.examenParcial.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse<T> {

    private String status;
    private String code;
    private String message;
    private T data;

    public WebResponse(String status, String code, String message) {

        this.code = code;
        this.status = status;
        this.message = message;
    }

}