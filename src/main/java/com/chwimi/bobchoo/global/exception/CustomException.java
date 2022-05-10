package com.chwimi.bobchoo.global.exception;

import com.chwimi.bobchoo.global.common.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final StatusEnum errorStatusEnum;

    public CustomException(StatusEnum errorStatusEnum, String message) {
        super(message);
        this.errorStatusEnum = errorStatusEnum;
    }
}
