package com.chwimi.bobchoo.survey;

import com.chwimi.bobchoo.global.entity.Food;
import com.chwimi.bobchoo.global.repository.*;
import com.chwimi.bobchoo.global.entity.FoodType;
import com.chwimi.bobchoo.global.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class SurveyRepositoryTest {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    private FoodRepositorySupport foodRepositorySupport;


    @Test
    @Transactional
    void 설문데이터확인() {
        List<Question> questions = questionRepository.findAll();
        assertThat(questions.size()).isEqualTo(9);
    }

    @Test
    @Transactional
    void 음식데이터확인() {
        List<String> types = new ArrayList<>();
        types.add("한식");
        types.add("매움");

        List<Food> foods = foodRepositorySupport.findListOfFoodByFoodType(types);
        Food food = foodRepositorySupport.findFoodByFoodType(types).get();

        System.out.println();
    }

    @Test
    void 음식타입확인() {
        List<FoodType> foodTypes = foodTypeRepository.findAll();

        System.out.println("ok");
    }
}
