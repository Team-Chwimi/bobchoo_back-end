package com.chwimi.bobchoo.global.exception;

import com.chwimi.bobchoo.global.common.BaseResponse;
import com.chwimi.bobchoo.global.common.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity noHandlerFoundException(NoHandlerFoundException e) {
        BaseResponse errorResponse = BaseResponse.of(StatusEnum.BAD_REQUEST, e.getClass().getName());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity customException(CustomException e) {
        StatusEnum errorStatusEnum = e.getErrorStatusEnum();
        BaseResponse errorResponse = BaseResponse.of(errorStatusEnum, e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorStatusEnum.getStatus()));
    }
}
