package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_food_taste")
public class FoodTaste extends BaseEntity {

    @Column(name = "spicy", nullable = false)
    private boolean spicy;

    @Column(name = "cool", nullable = false)
    private boolean cool;

    @OneToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
