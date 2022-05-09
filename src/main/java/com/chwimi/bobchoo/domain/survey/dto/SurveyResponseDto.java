package com.chwimi.bobchoo.domain.survey.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyResponseDto {
    private int questionTotalCount;
    private List<QuestionDto> questionList;

    public static SurveyResponseDto of(int questionTotalCount, List<QuestionDto> questionDtos) {
        return SurveyResponseDto.builder()
                .questionTotalCount(questionTotalCount)
                .questionList(questionDtos)
                .build();
    }
}
