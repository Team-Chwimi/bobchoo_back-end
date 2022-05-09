package com.chwimi.bobchoo.domain.survey.dto;

import com.chwimi.bobchoo.global.entity.Food;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodResDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long foodId;
    @JsonInclude
    private String foodName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String foodImg;

    public static FoodResDto ofOne(Food food) {
        return FoodResDto.builder()
                .foodName(food.getName())
                .foodImg(food.getImg())
                .build();
    }

    public static FoodResDto ofList(Food food) {
        return FoodResDto.builder()
                .foodId(food.getId())
                .foodName(food.getName())
                .build();

    }
}
