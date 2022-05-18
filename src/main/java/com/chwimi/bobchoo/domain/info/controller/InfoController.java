package com.chwimi.bobchoo.domain.info.controller;

import com.chwimi.bobchoo.domain.info.dto.CopyrightResDto;
import com.chwimi.bobchoo.domain.info.service.InfoService;
import com.chwimi.bobchoo.global.dto.FoodResDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(value = "Info API", tags = {"Info"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/copyrights")
    @ApiOperation(value = "음식 사진 저작권 정보 반환", notes = "인터넷에서 가져온 사진만 저작권 표시")
    public CopyrightResDto copyright() {
        return infoService.getCopyright();
    }

    @GetMapping("/food/{name}")
    @ApiOperation(value = "음식 정보 반환", notes = "음식 이름을 받아서 음식 사진 반환")
    public FoodResDto food(@PathVariable("name") String foodName) {
        return infoService.getFoodInfo(foodName);
    }


}
