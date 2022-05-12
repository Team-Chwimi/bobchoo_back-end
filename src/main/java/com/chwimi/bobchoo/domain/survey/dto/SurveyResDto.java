package com.chwimi.bobchoo.domain.survey.dto;

import com.chwimi.bobchoo.global.dto.QuestionResDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyResDto {
    @ApiModelProperty(name = "설문 총 갯수")
    private int questionTotalCount;
    @ApiModelProperty(name = "설문 리스트")
    private List<QuestionResDto> questionList;

    public static SurveyResDto of(int questionTotalCount, List<QuestionResDto> questionResDtos) {
        return SurveyResDto.builder()
                .questionTotalCount(questionTotalCount)
                .questionList(questionResDtos)
                .build();
    }
}
