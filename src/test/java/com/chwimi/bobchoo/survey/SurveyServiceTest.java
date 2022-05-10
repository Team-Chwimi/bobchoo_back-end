package com.chwimi.bobchoo.survey;

import com.chwimi.bobchoo.domain.survey.dto.AnswerReqDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResDto;
import com.chwimi.bobchoo.domain.survey.dto.SurveyResultReqDto;
import com.chwimi.bobchoo.domain.survey.service.SurveyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SurveyServiceTest {
    @Autowired
    private SurveyServiceImpl service;

    @Test
    @Transactional
    void 설문목록반환() {
        SurveyResDto surveys = service.getSurveys();
        System.out.println("ok");
    }

    @Test
    void 설문결과반환() {
        AnswerReqDto answerReqDto = AnswerReqDto.builder().build();
        List<AnswerReqDto> answerReqDtoList = new ArrayList<>();
        answerReqDtoList.add(answerReqDto);
        SurveyResultReqDto surveyResultReqDto = SurveyResultReqDto.of("test","test",answerReqDtoList);
//        service.surveyResult();
    }
}
