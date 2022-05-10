package com.chwimi.bobchoo.domain.survey.dto;

import com.chwimi.bobchoo.global.dto.QuestionResDto;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyResDto {
    private int questionTotalCount;
    private List<QuestionResDto> questionList;

    public static SurveyResDto of(int questionTotalCount, List<QuestionResDto> questionResDtos) {
        return SurveyResDto.builder()
                .questionTotalCount(questionTotalCount)
                .questionList(questionResDtos)
                .build();
    }
}
