package com.chwimi.bobchoo.domain.info.dto;

import com.chwimi.bobchoo.domain.survey.dto.FoodResDto;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CopyrightResDto {
    @JsonValue
    private List<FoodResDto> FoodResDtos;

    public static CopyrightResDto of(List<FoodResDto> foodResDtos) {
        return CopyrightResDto.builder()
                .FoodResDtos(foodResDtos)
                .build();
    }
}
