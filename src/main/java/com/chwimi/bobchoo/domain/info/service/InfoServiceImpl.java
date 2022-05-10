package com.chwimi.bobchoo.domain.info.service;

import com.chwimi.bobchoo.domain.info.dto.CopyrightResDto;
import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.chwimi.bobchoo.global.entity.Food;
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
}
