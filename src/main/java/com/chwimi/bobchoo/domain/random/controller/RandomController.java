package com.chwimi.bobchoo.domain.random.controller;

import com.chwimi.bobchoo.domain.random.dto.RandomResultReqDto;
import com.chwimi.bobchoo.domain.random.dto.SelectSurveyResDto;
import com.chwimi.bobchoo.domain.random.service.RandomService;
import com.chwimi.bobchoo.global.dto.FoodResDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "음식 랜덤 추천 API", tags = {"Random"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/random")
public class RandomController {

    private final RandomService randomService;

    @GetMapping
    @ApiOperation(value = "개수 선택 질문 반환")
    public SelectSurveyResDto random() {
        return randomService.getSelectSurvey();
    }

    @PostMapping("/results")
    @ApiOperation(value = "랜덤 추천 결과 반환")
    public FoodResDto result(@RequestBody RandomResultReqDto resultReqDto) {
        return randomService.randomResult(resultReqDto);
    }

    @PostMapping("/results/list")
    @ApiOperation(value = "랜덤 추천목록 결과 반환")
    public List<FoodResDto> resultList(@RequestBody RandomResultReqDto resultReqDto) {
        return randomService.randomResultList(resultReqDto);
    }
}
