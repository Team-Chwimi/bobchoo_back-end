package com.chwimi.bobchoo.domain.survey.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyResultReqDto {
    private String lat;
    private String lng;
    private List<AnswerReqDto> answerList;

    public static SurveyResultReqDto of(String lat, String lng, List<AnswerReqDto> answerList) {
        return SurveyResultReqDto.builder()
                .lat(lat)
                .lng(lng)
                .answerList(answerList)
                .build();
    }
}
