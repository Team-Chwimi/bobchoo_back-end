package com.chwimi.bobchoo.domain.random.service;

import com.chwimi.bobchoo.domain.random.dto.RandomResultReqDto;
import com.chwimi.bobchoo.domain.random.dto.SelectSurveyResDto;
import com.chwimi.bobchoo.global.dto.FoodResDto;

import java.util.List;

public interface RandomService {
    SelectSurveyResDto getSelectSurvey();

    FoodResDto randomResult(RandomResultReqDto resultReqDto);

    List<FoodResDto> randomResultList(RandomResultReqDto resultReqDto);
}
