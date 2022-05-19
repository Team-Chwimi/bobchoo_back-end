package com.chwimi.bobchoo.global.dto;

import com.chwimi.bobchoo.global.common.FoodTypeEnum;
import com.chwimi.bobchoo.global.common.StatusEnum;
import com.chwimi.bobchoo.global.exception.CustomException;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QueryTypeDto {
    private List<String> types;
    private List<String> ingredients;
    private List<String> shapes;
    private boolean isSpicy;
    private boolean isCool;

    public static QueryTypeDto of(List<String> query) {
        List<String> types = new ArrayList<>();
        List<String> ingredients = new ArrayList<>();
        List<String> shapes = new ArrayList<>();
        boolean isSpicy = false;
        boolean isCool = false;

        for (String q : query) {
            FoodTypeEnum foodTypeEnum = FoodTypeEnum.findByType(q);
            if (foodTypeEnum == null)
                throw new CustomException(StatusEnum.PARAMETER_INVALID, "음식 조건의 이름이 유효하지 않습니다.");
            Long id = foodTypeEnum.getTypeId();
            if (id <= 8L)
                types.add(q);
            else if (id == 9L)
                isSpicy = true;
            else if (id == 15L)
                isCool = true;
            else if (id == 10L || id == 11L)
                ingredients.add(q);
            else if (id >= 12L && id <= 14L)
                shapes.add(q);

        }

        return QueryTypeDto.builder()
                .types(types)
                .ingredients(ingredients)
                .shapes(shapes)
                .isSpicy(isSpicy)
                .isCool(isCool)
                .build();
    }
}
