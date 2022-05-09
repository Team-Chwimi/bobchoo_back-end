package com.chwimi.bobchoo.domain.survey.service;

import com.chwimi.bobchoo.domain.survey.dto.*;
import com.chwimi.bobchoo.global.entity.Food;
import com.chwimi.bobchoo.global.entity.FoodType;
import com.chwimi.bobchoo.global.entity.Satisfaction;
import com.chwimi.bobchoo.global.repository.*;
import com.chwimi.bobchoo.global.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

    private final QuestionRepository questionRepository;
    private final FoodRepository foodRepository;
    private final SatisfactionRepository satisfactionRepository;
    private final FoodRepositorySupport foodRepositorySupport;
    private final FoodTypeRepository foodTypeRepository;
    private static List<FoodType> foodTypes;    //인덱스가 0부터 시작한다는 점 유의 {idx:0 ~ , value:food_type_id}
    private static HashMap<Long, Integer> questionMatchFoodType; //1번 문항 제외

    @PostConstruct
    private void initStaticObject() {
        foodTypes = foodTypeRepository.findAll();
        questionMatchFoodType = new HashMap<>();
        questionMatchFoodType.put(2L, 12);
        questionMatchFoodType.put(3L, 13);
        questionMatchFoodType.put(4L, 10);
        questionMatchFoodType.put(5L, 14);
        questionMatchFoodType.put(6L, 11);
        questionMatchFoodType.put(7L, 9);
        questionMatchFoodType.put(8L, 15);
    }

    @Override
    public SurveyResponseDto getSurveys() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionDto> questionDtos = questions.stream()
                .map(o -> QuestionDto.of(o))
                .collect(Collectors.toList());
        return SurveyResponseDto.of(questions.size(), questionDtos);
    }

    @Override
    public FoodResDto surveyResult(SurveyResultReqDto resultReqDto) {
        List<String> types = foodTypeParsing(resultReqDto.getAnswerList());
        Food food = foodRepositorySupport.findFoodByFoodType(types);
        FoodResDto foodResDto = FoodResDto.ofOne(food);
        return foodResDto;
    }

    @Override
    public List<FoodResDto> surveyResultList(SurveyResultReqDto resultReqDto) {
        List<String> types = foodTypeParsing(resultReqDto.getAnswerList());
        List<Food> foods = foodRepositorySupport.findListOfFoodByFoodType(types);
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
                int foodTypeId = questionMatchFoodType.get(answerReqDto.getQuestionId());
                types.add(foodTypes.get(foodTypeId - 1).getType());
            }
        }
        return types;
    }

    @Override
    public boolean surveySatisfaction(SatisfactionReqDto satisfactionReqDto) {
        List<AnswerReqDto> answerReqDtos = satisfactionReqDto.getAnswerList();
        Set<String> answerSet = new HashSet<>();
        for (AnswerReqDto answerReqDto : answerReqDtos) {
            if (answerReqDto.getQuestionId() == 1L) {
                for (String answer : answerReqDto.getAnswer())
                    answerSet.add(answer);
            } else {
                answerSet.add(answerReqDto.getQuestionId().toString());
            }
        }

        Satisfaction satisfaction = Satisfaction.builder()
                .satisfaction(satisfactionReqDto.getSatisfaction())
                .foodName(satisfactionReqDto.getFoodName())
                .spicy(answerSet.contains("7"))
                .cool(answerSet.contains("8"))
                .rice(answerSet.contains("2"))
                .noodle(answerSet.contains("3"))
                .withoutRiceNoodle(answerReqDtos.contains("4"))
                .meat(answerSet.contains("5"))
                .seafood(answerSet.contains("6"))
                .korean(answerSet.contains("한식"))
                .western(answerSet.contains("양식"))
                .chinese(answerSet.contains("중식"))
                .japanese(answerSet.contains("일식"))
                .asian(answerSet.contains("아시아음식"))
                .snack(answerSet.contains("분식"))
                .fastfood(answerSet.contains("패스트푸드"))
                .etcfood(answerSet.contains("기타"))
                .build();
        satisfactionRepository.save(satisfaction);
        return true;
    }
}
