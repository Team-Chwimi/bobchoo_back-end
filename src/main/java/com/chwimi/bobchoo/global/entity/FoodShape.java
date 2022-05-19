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
@Table(name = "tb_food_shape")
public class FoodShape extends BaseEntity {

    @Column(name = "shape", length = 100, nullable = false)
    private String shape;

    @OneToMany(mappedBy = "foodShape")
    private List<FoodShapeInfo> foodShapeInfos;
}
