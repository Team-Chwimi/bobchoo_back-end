package com.chwimi.bobchoo.domain.random.controller;

import com.chwimi.bobchoo.domain.random.dto.RandomResultReqDto;
import com.chwimi.bobchoo.domain.random.dto.SelectSurveyResDto;
import com.chwimi.bobchoo.domain.random.service.RandomService;
import com.chwimi.bobchoo.global.dto.FoodResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/random")
public class RandomController {

    private final RandomService randomService;

    @GetMapping
    public SelectSurveyResDto random() {
        return randomService.getSelectSurvey();
    }

    @PostMapping("/results")
    public FoodResDto result(@RequestBody RandomResultReqDto resultReqDto) {
        return randomService.randomResult(resultReqDto);
    }

    @PostMapping("/results/list")
    public List<FoodResDto> resultList(@RequestBody RandomResultReqDto resultReqDto) {
        return randomService.randomResultList(resultReqDto);
    }
}
