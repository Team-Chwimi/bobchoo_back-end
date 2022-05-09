package com.chwimi.bobchoo.domain.survey.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AnswerReqDto {
    private Long questionId;
    private List<String> answer;
}
