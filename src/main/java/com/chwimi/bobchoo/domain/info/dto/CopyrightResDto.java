package com.chwimi.bobchoo.domain.info.dto;

import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CopyrightResDto {
    @JsonValue
    @ApiModelProperty(name = "음식 정보 목록", notes = "인터넷에서 가져온 사진을 사용한 음식 목록")
    private List<FoodResDto> FoodResDtos;

    public static CopyrightResDto of(List<FoodResDto> foodResDtos) {
        return CopyrightResDto.builder()
                .FoodResDtos(foodResDtos)
                .build();
    }
}
