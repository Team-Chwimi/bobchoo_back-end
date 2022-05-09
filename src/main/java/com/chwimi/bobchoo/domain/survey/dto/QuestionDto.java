package com.chwimi.bobchoo.domain.survey.dto;

import com.chwimi.bobchoo.global.entity.Question;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionDto {
    private Long questionId;
    private String question;
    private boolean overlap;
    private String description;
    private List<AnswerResDto> answerList;

    public static QuestionDto of(Question question) {
        return QuestionDto.builder()
                .questionId(question.getId())
                .question(question.getQuestion())
                .overlap(question.isOverLap())
                .description(question.getDescription())
                .answerList(question.getQuestionAnswers().stream()
                        .map(o -> AnswerResDto.of(o.getAnswer()))
                        .collect(Collectors.toList()))
                .build();
    }
}
