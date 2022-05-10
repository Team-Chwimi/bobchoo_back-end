package com.chwimi.bobchoo.domain.survey.controller;

import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.chwimi.bobchoo.domain.survey.dto.SatisfactionReqDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResultReqDto;
import com.chwimi.bobchoo.domain.survey.service.SurveyService;
import com.chwimi.bobchoo.global.common.BaseResponse;
import com.chwimi.bobchoo.global.common.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping
    public SurveyResDto surveys() {
        return surveyService.getSurveys();
    }

    @PostMapping("/results")
    public FoodResDto result(@RequestBody SurveyResultReqDto resultReqDto) {
        return surveyService.surveyResult(resultReqDto);
    }

    @PostMapping("/results/list")
    public List<FoodResDto> resultList(@RequestBody SurveyResultReqDto resultReqDto) {
        return surveyService.surveyResultList(resultReqDto);
    }

    @PostMapping("/satisfactions")
    public BaseResponse satisfaction(@RequestBody SatisfactionReqDto satisfactionReqDto) {
        surveyService.surveySatisfaction(satisfactionReqDto);
        return BaseResponse.of(StatusEnum.REQUEST_SUCCESS, "satisfactions success");
    }

}
