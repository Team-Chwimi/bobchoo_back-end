package com.chwimi.bobchoo.global.dto;

import com.chwimi.bobchoo.global.entity.Food;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Builder
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodResDto {
    @ApiModelProperty(name = "음식 id")
    private Long foodId;
    @ApiModelProperty(name = "음식 이름")
    private String foodName;
    @ApiModelProperty(name = "음식 이미지 주소")
    private String foodImg;
    @ApiModelProperty(name = "음식 이미지 출처 url", notes = "인터넷에서 가져온 이미지만 출처 url 존재")
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
