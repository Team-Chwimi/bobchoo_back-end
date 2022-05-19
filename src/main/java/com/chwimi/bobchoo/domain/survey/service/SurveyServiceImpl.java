package com.chwimi.bobchoo.domain.survey.service;

import com.chwimi.bobchoo.domain.survey.dto.*;
import com.chwimi.bobchoo.global.common.FoodTypeEnum;
import com.chwimi.bobchoo.global.common.StatusEnum;
import com.chwimi.bobchoo.global.dto.FoodResDto;
import com.chwimi.bobchoo.global.dto.QuestionResDto;
import com.chwimi.bobchoo.global.entity.Food;
import com.chwimi.bobchoo.global.entity.Question;
import com.chwimi.bobchoo.global.entity.Satisfaction;
import com.chwimi.bobchoo.global.exception.CustomException;
import com.chwimi.bobchoo.global.repository.FoodRepositorySupport;
import com.chwimi.bobchoo.global.repository.QuestionRepository;
import com.chwimi.bobchoo.global.repository.SatisfactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final QuestionRepository questionRepository;
    private final SatisfactionRepository satisfactionRepository;
    private final FoodRepositorySupport foodRepositorySupport;

    @Override
    public SurveyResDto getSurveys() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionResDto> questionResDtos = questions.stream()
                .map(o -> QuestionResDto.of(o))
                .collect(Collectors.toList());
        return SurveyResDto.of(questions.size(), questionResDtos);
    }

    @Override
    public FoodResDto surveyResult(SurveyResultReqDto resultReqDto) {
        List<String> types = foodTypeParsing(resultReqDto.getAnswerList());
        Food food = foodRepositorySupport.findFoodByFoodType(types).orElseThrow(
                () -> new CustomException(StatusEnum.DATA_NOT_FOUND, "조건에 해당하는 음식을 찾을 수 없습니다.")
        );
        FoodResDto foodResDto = FoodResDto.ofOne(food);
        return foodResDto;
    }

    @Override
    public List<FoodResDto> surveyResultList(SurveyResultReqDto resultReqDto) {
        List<String> types = foodTypeParsing(resultReqDto.getAnswerList());
        List<Food> foods = foodRepositorySupport.findListOfFoodByFoodType(types);
        if (foods == null)
            throw new CustomException(StatusEnum.DATA_NOT_FOUND, "조건에 해당하는 음식을 찾을 수 없습니다.");
        List<FoodResDto> foodResDtos = foods.stream()
                .map(o -> FoodResDto.ofList(o))
                .collect(Collectors.toList());
        return foodResDtos;
    }

    private List<String> foodTypeParsing(List<AnswerReqDto> answerReqDtos) {
        List<String> types = new ArrayList<>();
        for (AnswerReqDto answerReqDto : answerReqDtos) {
            if (answerReqDto.getQuestionId() == 1L) {
                for (String answer : answerReqDto.getAnswer())
                    types.add(answer);
            } else {
                FoodTypeEnum foodType = FoodTypeEnum.findByQuestionId(answerReqDto.getQuestionId());
                types.add(foodType.getType());
            }
        }
        return types;
    }

    @Override
    public boolean surveySatisfaction(SatisfactionReqDto satisfactionReqDto) {
        List<AnswerReqDto> answerReqDtos = satisfactionReqDto.getAnswerList();
        Set<FoodTypeEnum> foodTypeSet = EnumSet.noneOf(FoodTypeEnum.class);
        for (AnswerReqDto answerReqDto : answerReqDtos) {
            if (answerReqDto.getQuestionId() == 1L) {   //어떤 종류의 음식인지 (한식, 양식, 중식...)
                for (String answer : answerReqDto.getAnswer())
                    foodTypeSet.add(FoodTypeEnum.findByType(answer));
            } else //다른 질문일 때는 questionId로 판별
                foodTypeSet.add(FoodTypeEnum.findByQuestionId(answerReqDto.getQuestionId()));
        }

        Satisfaction satisfaction = Satisfaction.builder()
                .satisfaction(satisfactionReqDto.getSatisfaction())
                .foodName(satisfactionReqDto.getFoodName())
                .spicy(foodTypeSet.contains(FoodTypeEnum.SPICY))
                .cool(foodTypeSet.contains(FoodTypeEnum.COOL))
                .rice(foodTypeSet.contains(FoodTypeEnum.RICE))
                .noodle(foodTypeSet.contains(FoodTypeEnum.NOODLE))
                .withoutRiceNoodle(foodTypeSet.contains(FoodTypeEnum.WITHOUT_RICE_NOODLE))
                .meat(foodTypeSet.contains(FoodTypeEnum.MEAT))
                .seafood(foodTypeSet.contains(FoodTypeEnum.SEAFOOD))
                .korean(foodTypeSet.contains(FoodTypeEnum.KOREAN))
                .western(foodTypeSet.contains(FoodTypeEnum.WESTERN))
                .chinese(foodTypeSet.contains(FoodTypeEnum.CHINESE))
                .japanese(foodTypeSet.contains(FoodTypeEnum.JAPANESE))
                .asian(foodTypeSet.contains(FoodTypeEnum.ASIAN))
                .snack(foodTypeSet.contains(FoodTypeEnum.SNACK))
                .fastfood(foodTypeSet.contains(FoodTypeEnum.FAST_FOOD))
                .etcfood(foodTypeSet.contains(FoodTypeEnum.ETC_FOOD))
                .build();
        satisfactionRepository.save(satisfaction);
        return true;
    }
}
