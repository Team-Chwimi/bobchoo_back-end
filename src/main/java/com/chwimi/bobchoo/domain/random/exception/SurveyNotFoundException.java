package com.chwimi.bobchoo.domain.random.exception;

import com.chwimi.bobchoo.global.common.StatusEnum;
import com.chwimi.bobchoo.global.exception.CustomException;

public class SurveyNotFoundException extends CustomException {

    public SurveyNotFoundException(StatusEnum errorStatusEnum, String message) {
        super(errorStatusEnum, message);
    }
}
