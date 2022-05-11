package com.chwimi.bobchoo.global.dto;

import com.chwimi.bobchoo.global.entity.Question;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionResDto {
    @ApiModelProperty(name = "질문 id")
    private Long questionId;
    @ApiModelProperty(name = "질문 내용")
    private String question;
    @ApiModelProperty(name = "다중 응답 가능 유무", notes = "다중 응답이 가능한 질문이면 true")
    private boolean overlap;
    @ApiModelProperty(name = "질문 설명", notes = "설명이 필요한 질문에만 존재")
    private String description;
    @ApiModelProperty(name = "답변 목록", notes = "질문에 해당하는 답변 목록")
    private List<AnswerResDto> answerList;

    public static QuestionResDto of(Question question) {
        return QuestionResDto.builder()
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
