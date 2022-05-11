package com.chwimi.bobchoo.domain.survey.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyResultReqDto {
    @ApiModelProperty(name = "위도")
    private String lat;
    @ApiModelProperty(name = "경도")
    private String lng;
    @ApiModelProperty(name = "응답 목록", notes = "첫번째 질문에서 선택한 응답이나 Yes를 선택한 응답 목록", required = true)
    private List<AnswerReqDto> answerList;

    public static SurveyResultReqDto of(String lat, String lng, List<AnswerReqDto> answerList) {
        return SurveyResultReqDto.builder()
                .lat(lat)
                .lng(lng)
                .answerList(answerList)
                .build();
    }
}
