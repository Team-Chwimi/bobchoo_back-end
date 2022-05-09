package com.chwimi.bobchoo.domain.survey.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SatisfactionReqDto {
    private List<AnswerReqDto> answerList;
    private String foodName;
    private int satisfaction;
}
