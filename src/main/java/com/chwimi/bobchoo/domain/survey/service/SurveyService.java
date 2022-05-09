package com.chwimi.bobchoo.domain.survey.service;

import com.chwimi.bobchoo.domain.survey.dto.FoodResDto;
import com.chwimi.bobchoo.domain.survey.dto.SatisfactionReqDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResponseDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResultReqDto;

import java.util.List;

public interface SurveyService {
    SurveyResponseDto getSurveys();

    FoodResDto surveyResult(SurveyResultReqDto resultReqDto);

    List<FoodResDto> surveyResultList(SurveyResultReqDto resultReqDto);

    boolean surveySatisfaction(SatisfactionReqDto satisfactionReqDto);
}
