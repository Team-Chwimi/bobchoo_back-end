package com.chwimi.bobchoo.domain.random.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ApiModel
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RandomResultReqDto {
    @ApiModelProperty(name = "위도")
    private String lat;
    @ApiModelProperty(name = "경도")
    private String lng;
}
