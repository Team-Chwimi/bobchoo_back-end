package com.chwimi.bobchoo.domain.survey.dto;

import com.chwimi.bobchoo.global.entity.Food;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodResDto {
    private Long foodId;
    private String foodName;
    private String foodImg;
    private String foodURL;

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

    public static FoodResDto ofCopyright(Food food) {
        return FoodResDto.builder()
                .foodId(food.getId())
                .foodName(food.getName())
                .foodURL(food.getImgCopyright())
                .build();
    }
}
