package com.chwimi.bobchoo.domain.survey.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerReqDto {
    @ApiModelProperty(name = "질문 id", required = true)
    private Long questionId;
    @ApiModelProperty(name = "답변 리스트", required = true)
    private List<String> answer;
}
