package com.chwimi.bobchoo.domain.random.service;

import com.chwimi.bobchoo.domain.random.dto.RandomResultReqDto;
import com.chwimi.bobchoo.domain.random.exception.SurveyNotFoundException;
import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.chwimi.bobchoo.global.common.StatusEnum;
import com.chwimi.bobchoo.global.dto.QuestionResDto;
import com.chwimi.bobchoo.global.entity.Food;
import com.chwimi.bobchoo.global.entity.Question;
import com.chwimi.bobchoo.global.repository.FoodRepositorySupport;
import com.chwimi.bobchoo.global.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RandomServiceImpl implements RandomService {

    private final QuestionRepository questionRepository;
    private final FoodRepositorySupport foodRepositorySupport;

    @Override
    public QuestionResDto getSelectSurvey() {
        Question question = questionRepository.findById(9L).orElseThrow(
                () -> new SurveyNotFoundException(StatusEnum.INTERNAL_SERVER_ERROR, "설문이 존재하지않습니다.")
        );
        return QuestionResDto.of(question);
    }

    @Override
    public FoodResDto randomResult(RandomResultReqDto resultReqDto) {
        Food food = foodRepositorySupport.findFood();
        FoodResDto foodResDto = FoodResDto.ofOne(food);
        return foodResDto;
    }

    @Override
    public List<FoodResDto> randomResultList(RandomResultReqDto resultReqDto) {
        List<Food> foods = foodRepositorySupport.findListOfFood();
        List<FoodResDto> foodResDtos = foods.stream()
                .map(o -> FoodResDto.ofList(o))
                .collect(Collectors.toList());
        return foodResDtos;
    }
}
