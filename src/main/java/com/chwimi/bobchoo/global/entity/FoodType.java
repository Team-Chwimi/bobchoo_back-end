package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_food_type")
public class FoodType extends BaseEntity {

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @OneToMany(mappedBy = "foodType")
    private List<FoodTypeInfo> foodTypeInfos;
}
