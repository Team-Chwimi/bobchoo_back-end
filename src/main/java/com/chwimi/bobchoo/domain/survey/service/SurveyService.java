package com.chwimi.bobchoo.domain.survey.service;

import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.chwimi.bobchoo.domain.survey.dto.SatisfactionReqDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResultReqDto;

import java.util.List;

public interface SurveyService {
    SurveyResDto getSurveys();

    FoodResDto surveyResult(SurveyResultReqDto resultReqDto);

    List<FoodResDto> surveyResultList(SurveyResultReqDto resultReqDto);

    boolean surveySatisfaction(SatisfactionReqDto satisfactionReqDto);
}
