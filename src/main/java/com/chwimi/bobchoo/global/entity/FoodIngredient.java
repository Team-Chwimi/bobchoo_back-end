package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_food_Ingredients")
public class FoodIngredient extends BaseEntity {

    @Column(name = "ingredients", length = 100, nullable = false)
    private String ingredient;

    @OneToMany(mappedBy = "foodIngredient")
    private List<FoodIngredientInfo> foodIngredientInfos;
}
