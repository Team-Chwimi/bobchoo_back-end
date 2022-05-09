package com.chwimi.bobchoo.global.repository;

import com.chwimi.bobchoo.global.entity.*;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;
    private QFood qFood = QFood.food;
    private QFoodType qFoodType = QFoodType.foodType;
    private QFoodInfo qFoodInfo = QFoodInfo.foodInfo;

    public List<Food> findListOfFoodByFoodType(List<String> types) {
        return findFoodByFoodTypeQuery(types)
                .limit(5)
                .fetch();
    }

    public Food findFoodByFoodType(List<String> types) {
        return findFoodByFoodTypeQuery(types)
                .fetchFirst();
    }

    private JPAQuery<Food> findFoodByFoodTypeQuery(List<String> types) {
        return jpaQueryFactory.selectFrom(qFood)
                .innerJoin(qFoodInfo).on(qFood.id.eq(qFoodInfo.food.id))
                .innerJoin(qFoodType).on(qFoodType.id.eq(qFoodInfo.foodType.id))
                .where(qFoodType.type.in(types))
                .groupBy(qFood)
                .having(qFoodType.type.count().eq(Long.valueOf(types.size())))
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc());
    }
}
