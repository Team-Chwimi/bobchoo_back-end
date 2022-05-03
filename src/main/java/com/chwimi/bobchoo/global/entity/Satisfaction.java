package com.chwimi.bobchoo.global.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_satisfaction")
public class Satisfaction {

    @Id
    @Column(name = "satisfaction_id")
    private Long satisfactionId;

    @Column(name = "satisfaction")
    private Integer satisfaction;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "spicy")
    private Integer spicy;

    @Column(name = "cool")
    private Integer cool;

    @Column(name = "rice")
    private Integer rice;

    @Column(name = "noodle")
    private Integer noodle;

    @Column(name = "without_rice_noodle")
    private Integer withOutRiceNoodle;

    @Column(name = "meat")
    private Integer meat;

    @Column(name = "seafood")
    private Integer seafood;

    @Column(name = "korean")
    private Integer korean;

    @Column(name = "western")
    private Integer western;

    @Column(name = "chinese")
    private Integer chinese;

    @Column(name = "japanese")
    private Integer japanese;

    @Column(name = "asian")
    private Integer asian;

    @Column(name = "snack")
    private Integer snack;

    @Column(name = "fastfood")
    private Integer fastfood;

    @Column(name = "etcfood")
    private Integer etcfood;
}
