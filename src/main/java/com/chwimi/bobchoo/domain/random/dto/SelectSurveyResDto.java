package com.chwimi.bobchoo.domain.random.dto;

import com.chwimi.bobchoo.domain.survey.dto.AnswerResDto;
import com.chwimi.bobchoo.global.entity.Question;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SelectSurveyResDto {
    private String question;
    private List<AnswerResDto> answerList;

    public static SelectSurveyResDto of(Question question) {
        return SelectSurveyResDto.builder()
                .question(question.getQuestion())
                .answerList(question.getQuestionAnswers().stream()
                        .map(o -> AnswerResDto.of(o.getAnswer()))
                        .collect(Collectors.toList()))
                .build();
    }
}
