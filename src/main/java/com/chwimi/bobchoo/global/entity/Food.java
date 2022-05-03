package com.chwimi.bobchoo.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "food_name", length = 100)
    private String foodName;

    @Column(name = "food_img", length = 1000)
    private String foodImg;

    @Column(name = "food_img_copyright", length = 1000)
    private String foodImgCopyright;

    @OneToMany(mappedBy = "food")
    private Set<FoodInfo> foodInfos;


}
