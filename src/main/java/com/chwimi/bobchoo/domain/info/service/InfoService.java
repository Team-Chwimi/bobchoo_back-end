package com.chwimi.bobchoo.domain.info.service;

import com.chwimi.bobchoo.domain.info.dto.CopyrightResDto;
import com.chwimi.bobchoo.global.dto.FoodResDto;

public interface InfoService {
    CopyrightResDto getCopyright();

    FoodResDto getFoodInfo(String foodName);
}
