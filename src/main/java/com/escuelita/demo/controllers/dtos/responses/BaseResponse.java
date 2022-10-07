package com.escuelita.demo.controllers.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder @Getter
public class BaseResponse {

    private Object data;
    private String message;
    private Boolean success;
    private HttpStatus httpStatus;

}
