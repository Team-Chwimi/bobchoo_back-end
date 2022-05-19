package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_food")
public class Food extends BaseEntity {

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "img", length = 1000)
    private String img;

    @Column(name = "img_copyright", length = 1000)
    private String imgCopyright;

    @OneToMany(mappedBy = "food")
    private List<FoodTypeInfo> foodTypeInfos;

    @OneToMany(mappedBy = "food")
    private List<FoodIngredientInfo> foodIngredientInfos;

    @OneToMany(mappedBy = "food")
    private List<FoodShapeInfo> foodShapeInfos;

    @OneToOne(mappedBy = "food")
    private FoodTaste foodTaste;

}
