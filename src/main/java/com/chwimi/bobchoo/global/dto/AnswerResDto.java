package com.chwimi.bobchoo.global.dto;

import com.chwimi.bobchoo.global.entity.Answer;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerResDto {
    @JsonValue
    private String answer;

    public static AnswerResDto of(Answer answer) {
        return AnswerResDto.builder()
                .answer(answer.getAnswer())
                .build();
    }
}
