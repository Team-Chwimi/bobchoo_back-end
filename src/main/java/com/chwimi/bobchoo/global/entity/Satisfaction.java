package com.chwimi.bobchoo.global.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_satisfaction")
public class Satisfaction extends BaseEntity {

    @Column(name = "satisfaction", nullable = false)
    private Integer satisfaction;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "spicy")
    private boolean spicy;

    @Column(name = "cool")
    private boolean cool;

    @Column(name = "rice")
    private boolean rice;

    @Column(name = "noodle")
    private boolean noodle;

    @Column(name = "without_rice_noodle")
    private boolean withoutRiceNoodle;

    @Column(name = "meat")
    private boolean meat;

    @Column(name = "seafood")
    private boolean seafood;

    @Column(name = "korean")
    private boolean korean;

    @Column(name = "western")
    private boolean western;

    @Column(name = "chinese")
    private boolean chinese;

    @Column(name = "japanese")
    private boolean japanese;

    @Column(name = "asian")
    private boolean asian;

    @Column(name = "snack")
    private boolean snack;

    @Column(name = "fastfood")
    private boolean fastfood;

    @Column(name = "etcfood")
    private boolean etcfood;
}
