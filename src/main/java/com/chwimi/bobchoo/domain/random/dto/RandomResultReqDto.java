package com.chwimi.bobchoo.domain.random.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RandomResultReqDto {
    private String lat;
    private String lng;
}
