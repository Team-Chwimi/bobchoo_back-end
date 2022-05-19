package com.chwimi.bobchoo.global.common;

import lombok.Getter;

@Getter
public enum StatusEnum {

    REQUEST_SUCCESS("REQUEST_SUCCESS", 200),
    BAD_REQUEST("BAD_REQUEST", 400),
    INTERNAL_SERVER_ERROR("INTERNAL SERVER ERROR", 500),
    DATA_NOT_FOUND("DATA NOT FOUND", 404),
    PARAMETER_INVALID("PARAMETER_INVALID", 416);

    String message;
    int status;

    StatusEnum(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
