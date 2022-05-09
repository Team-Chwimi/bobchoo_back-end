package com.chwimi.bobchoo.global.common;

import java.util.HashMap;
import java.util.Map;

public enum FoodTypeEnum {

    KOREAN("한식", 1L, 1L),
    WESTERN("양식", 2L, 1L),
    CHINESE("중식", 3L, 1L),
    JAPANESE("일식", 4L, 1L),
    ASIAN("아시아음식", 5L, 1L),
    SNACK("분식", 6L, 1L),
    FAST_FOOD("패스트푸드", 7L, 1L),
    ETC_FOOD("기타", 8L, 1L),
    SPICY("매움", 9l, 7L),
    MEAT("고기", 10L, 5L),
    SEAFOOD("해산물", 11L, 6L),
    RICE("밥", 12L, 2L),
    NOODLE("면", 13L, 3L),
    WITHOUT_RICE_NOODLE("밥, 면 아닌 음식", 14L, 4L),
    COOL("시원", 15l, 8L);

    String type;
    Long typeId;
    Long questionId;

    private static final Map<String, FoodTypeEnum> typeToEnum = new HashMap<>();
    private static final Map<Long, FoodTypeEnum> questionIdToEnum = new HashMap<>();

    static {
        for (FoodTypeEnum foodTypeEnum : values()) {
            typeToEnum.put(foodTypeEnum.getType(), foodTypeEnum);
            questionIdToEnum.put(foodTypeEnum.getQuestionId(), foodTypeEnum);
        }
    }

    FoodTypeEnum(String type, Long typeId, Long questionId) {
        this.type = type;
        this.typeId = typeId;
        this.questionId = questionId;
    }

    public String getType() {
        return type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public static FoodTypeEnum findByQuestionId(Long id) {
        return questionIdToEnum.get(id);
    }

    public static FoodTypeEnum findByType(String type) {
        return typeToEnum.get(type);
    }

}
