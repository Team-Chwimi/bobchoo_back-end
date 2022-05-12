package com.chwimi.bobchoo.domain.random.dto;

import com.chwimi.bobchoo.global.dto.AnswerResDto;
import com.chwimi.bobchoo.global.entity.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SelectSurveyResDto {
    @ApiModelProperty(name = "질문 내용", notes = "몇개의 결과를 받을건지 물어보는 질문")
    private String question;
    @ApiModelProperty(name = "답변 목록")
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
