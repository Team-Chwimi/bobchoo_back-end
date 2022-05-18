package com.chwimi.bobchoo.domain.info.service;

import com.chwimi.bobchoo.domain.info.dto.CopyrightResDto;
import com.chwimi.bobchoo.global.common.StatusEnum;
import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.chwimi.bobchoo.global.entity.Food;
import com.chwimi.bobchoo.global.exception.CustomException;
import com.chwimi.bobchoo.global.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InfoServiceImpl implements InfoService {

    private final FoodRepository foodRepository;

    @Override
    public CopyrightResDto getCopyright() {
        List<Food> foods = foodRepository.findAllByImgCopyrightIsNotNull();
        List<FoodResDto> foodResDtos = foods.stream()
                .map(o -> FoodResDto.ofCopyright(o))
                .collect(Collectors.toList());

        return CopyrightResDto.of(foodResDtos);
    }

    @Override
    public FoodResDto getFoodInfo(String foodName) {
        Food food = foodRepository.findFoodByName(foodName).orElseThrow(
                () -> new CustomException(StatusEnum.PARAMETER_INVALID, "["+foodName+"]라는 이름의 음식이 DB에 없습니다.")
        );
        return FoodResDto.ofOne(food);
    }
}
