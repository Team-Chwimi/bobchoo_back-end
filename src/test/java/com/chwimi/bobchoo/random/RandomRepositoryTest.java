package com.chwimi.bobchoo.random;

import com.chwimi.bobchoo.global.entity.Food;
import com.chwimi.bobchoo.global.repository.FoodRepositorySupport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RandomRepositoryTest {

    @Autowired
    private FoodRepositorySupport foodRepositorySupport;

    @Test
    void 랜덤음식뽑아오기() {
        Food food = foodRepositorySupport.findFood();

        Assertions.assertThat(food).isNotNull();
    }

    @Test
    void 랜덤음식리스트뽑아오기() {
        List<Food> foods = foodRepositorySupport.findListOfFood();

        Assertions.assertThat(foods).isNotNull();
    }
}
