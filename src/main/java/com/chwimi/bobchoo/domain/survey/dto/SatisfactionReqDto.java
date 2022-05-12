package com.chwimi.bobchoo.domain.survey.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SatisfactionReqDto {
    @ApiModelProperty(name = "응답 목록", notes = "첫번째 질문에서 선택한 응답이나 Yes를 선택한 응답 목록", required = true)
    private List<AnswerReqDto> answerList;
    @ApiModelProperty(name = "음식 이름", required = true)
    private String foodName;
    @ApiModelProperty(name = "만족도", notes = "1부터 5까지의 정수", required = true)
    private int satisfaction;
}
