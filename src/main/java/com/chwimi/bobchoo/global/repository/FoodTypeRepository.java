package com.chwimi.bobchoo.global.repository;

import com.chwimi.bobchoo.global.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
