package com.chwimi.bobchoo.global.repository;

import com.chwimi.bobchoo.global.entity.Satisfaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisfactionRepository extends JpaRepository<Satisfaction, Long> {
}
