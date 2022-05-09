package com.chwimi.bobchoo.global.common;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseResponse {
    private StatusEnum code;
    private String message;

    public static BaseResponse of(StatusEnum code, String message) {
        return new BaseResponse(code, message);
    }

}
