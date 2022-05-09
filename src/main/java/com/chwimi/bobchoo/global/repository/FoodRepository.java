package com.chwimi.bobchoo.global.repository;

import com.chwimi.bobchoo.global.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
