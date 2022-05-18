package com.chwimi.bobchoo.domain.survey.controller;

import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.chwimi.bobchoo.domain.survey.dto.SatisfactionReqDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResultReqDto;
import com.chwimi.bobchoo.domain.survey.service.SurveyService;
import com.chwimi.bobchoo.global.common.BaseResponse;
import com.chwimi.bobchoo.global.common.StatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "음식 설문 추천 API", tags = {"Surveys"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping
    @ApiOperation(value = "설문 목록 반환", notes = "음식 취향 조사에 필요한 설문 목록을 보내줌")
    public SurveyResDto surveys() {
        return surveyService.getSurveys();
    }

    @PostMapping("/results")
    @ApiOperation(value = "설문 추천 결과 반환", notes = "설문 결과에 부합하는 음식을 하나 뽑아서 추천해줌")
    public FoodResDto result(@RequestBody SurveyResultReqDto resultReqDto) {
        return surveyService.surveyResult(resultReqDto);
    }

    @PostMapping("/results/list")
    @ApiOperation(value = "설문 추천목록 결과 반환", notes = "설문 결과에 부합하는 음식을 여러개 뽑아서 추천해줌")
    public List<FoodResDto> resultList(@RequestBody SurveyResultReqDto resultReqDto) {
        return surveyService.surveyResultList(resultReqDto);
    }

    @PostMapping("/satisfactions")
    @ApiOperation(value = "만족도 조사 결과 반환", notes = "사용자의 만족도와 사용자의 설문 내역을 받아서 저장함")
    public BaseResponse satisfaction(@RequestBody SatisfactionReqDto satisfactionReqDto) {
        surveyService.surveySatisfaction(satisfactionReqDto);
        return BaseResponse.of(StatusEnum.REQUEST_SUCCESS, "satisfactions success");
    }

}
