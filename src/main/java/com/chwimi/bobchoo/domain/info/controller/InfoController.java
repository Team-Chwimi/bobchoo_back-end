package com.chwimi.bobchoo.domain.info.controller;

import com.chwimi.bobchoo.domain.info.dto.CopyrightResDto;
import com.chwimi.bobchoo.domain.info.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/info")
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/copyrights")
    public CopyrightResDto copyright() {
        return infoService.getCopyright();
    }

}
