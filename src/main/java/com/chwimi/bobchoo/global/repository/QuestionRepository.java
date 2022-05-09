package com.chwimi.bobchoo.global.repository;

import com.chwimi.bobchoo.global.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
