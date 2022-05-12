package com.chwimi.bobchoo.global.dto;

import com.chwimi.bobchoo.global.entity.Answer;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerResDto {
    @JsonValue
    @ApiModelProperty(name = "답변")
    private String answer;

    public static AnswerResDto of(Answer answer) {
        return AnswerResDto.builder()
                .answer(answer.getAnswer())
                .build();
    }
}
