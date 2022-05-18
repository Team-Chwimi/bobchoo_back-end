package com.chwimi.bobchoo.global.repository;

import com.chwimi.bobchoo.global.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByImgCopyrightIsNotNull();
    Optional<Food> findFoodByName(String name);
}
