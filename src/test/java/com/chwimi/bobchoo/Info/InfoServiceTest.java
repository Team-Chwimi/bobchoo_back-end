package com.chwimi.bobchoo.Info;

import com.chwimi.bobchoo.domain.info.dto.CopyrightResDto;
import com.chwimi.bobchoo.domain.info.service.InfoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InfoServiceTest {
    @Autowired
    private InfoService infoService;

    @Test
    void 이미지출처반환() {
        CopyrightResDto copyrightResDto = infoService.getCopyright();
        Assertions.assertThat(copyrightResDto).isNotNull();
    }
}
