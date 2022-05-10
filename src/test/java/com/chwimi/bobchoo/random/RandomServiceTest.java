package com.chwimi.bobchoo.random;

import com.chwimi.bobchoo.domain.random.dto.RandomResultReqDto;
import com.chwimi.bobchoo.domain.random.service.RandomService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class RandomServiceTest {
    @Autowired
    private RandomService randomService;

    private static RandomResultReqDto randomResultReqDto;

    @BeforeAll
    static void Req객체초기화() {
        randomResultReqDto = RandomResultReqDto.builder()
                .lat("test")
                .lng("test")
                .build();
    }

    @Test
    @Transactional
    void 선택설문지반환() {
        Assertions.assertThat(randomService.getSelectSurvey()).isNotNull();
    }

    @Test
    void 랜덤음식받아오기() {
        Assertions.assertThat(randomService.randomResult(randomResultReqDto)).isNotNull();
    }

    @Test
    void 랜덤음식리스트받아오기() {
        Assertions.assertThat(randomService.randomResultList(randomResultReqDto)).isNotNull();
    }
}
