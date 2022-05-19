package com.chwimi.bobchoo.global.repository;

import com.chwimi.bobchoo.global.dto.QueryTypeDto;
import com.chwimi.bobchoo.global.entity.*;
import com.querydsl.core.types.Visitor;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodRepositorySupport {

    private static final int LIST_SIZE = 5;
    private final JPAQueryFactory jpaQueryFactory;
    private QFood qFood = QFood.food;
    private QFoodType qFoodType = QFoodType.foodType;
    private QFoodTypeInfo qFoodTypeInfo = QFoodTypeInfo.foodTypeInfo;
    private QFoodIngredient qFoodIngredient = QFoodIngredient.foodIngredient;
    private QFoodIngredientInfo qFoodIngredientInfo = QFoodIngredientInfo.foodIngredientInfo;
    private QFoodShape qFoodShape = QFoodShape.foodShape;
    private QFoodShapeInfo qFoodShapeInfo = QFoodShapeInfo.foodShapeInfo;
    private QFoodTaste qFoodTaste = QFoodTaste.foodTaste;

    public List<Food> findListOfFoodByFoodType(QueryTypeDto queryTypeDto) {
        return findFoodByFoodTypeQuery(queryTypeDto)
                .limit(LIST_SIZE)
                .fetch();
    }

    public Optional<Food> findFoodByFoodType(QueryTypeDto queryTypeDto) {
        return Optional.ofNullable(findFoodByFoodTypeQuery(queryTypeDto)
                .fetchFirst());
    }

    private JPAQuery<Food> findFoodByFoodTypeQuery(QueryTypeDto queryTypeDto) {
        return jpaQueryFactory.selectFrom(qFood)
                .innerJoin(qFoodTypeInfo).on(qFood.id.eq(qFoodTypeInfo.food.id))
                .innerJoin(qFoodType).on(qFoodType.id.eq(qFoodTypeInfo.foodType.id))
                .innerJoin(qFoodIngredientInfo).on(qFood.id.eq(qFoodIngredientInfo.food.id))
                .innerJoin(qFoodIngredient).on(qFoodIngredient.id.eq(qFoodIngredientInfo.foodIngredient.id))
                .innerJoin(qFoodShapeInfo).on(qFood.id.eq(qFoodShapeInfo.food.id))
                .innerJoin(qFoodShape).on(qFoodShape.id.eq(qFoodShapeInfo.foodShape.id))
                .innerJoin(qFoodTaste).on(qFood.id.eq(qFoodTaste.id))
                .where(eqFoodType(queryTypeDto.getTypes()), eqFoodIngredient(queryTypeDto.getIngredients()), eqFoodShape(queryTypeDto.getShapes()), eqFoodTaste(queryTypeDto.isSpicy(), queryTypeDto.isCool()))
                .groupBy(qFood)
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc());
    }

    private BooleanExpression eqFoodType(List<String> types) {
        if (types.size() == 0)
            return null;
        return qFoodType.type.in(types);
    }

    private BooleanExpression eqFoodIngredient(List<String> ingredients) {
        if (ingredients.size() == 0)
            return null;
        return qFoodIngredient.ingredient.in(ingredients);
    }

    private BooleanExpression eqFoodShape(List<String> shapes) {
        if (shapes.size() == 0)
            return null;
        return qFoodShape.shape.in(shapes);
    }

    private BooleanExpression eqFoodTaste(boolean isSpicy, boolean isCool) {
        if (!isSpicy && !isCool)
            return qFoodTaste.spicy.eq(false).and(qFoodTaste.cool.eq(false));
        if (!isSpicy)
            return qFoodTaste.spicy.eq(false);
        if (!isCool)
            return qFoodTaste.cool.eq(false);

        return null;
    }

    public List<Food> findListOfFood() {
        return findFoodQuery()
                .limit(LIST_SIZE)
                .fetch();
    }

    public Food findFood() {
        return findFoodQuery()
                .fetchFirst();
    }

    private JPAQuery<Food> findFoodQuery() {
        return jpaQueryFactory.selectFrom(qFood)
                .innerJoin(qFoodTypeInfo).on(qFood.id.eq(qFoodTypeInfo.food.id))
                .innerJoin(qFoodType).on(qFoodType.id.eq(qFoodTypeInfo.foodType.id))
                .groupBy(qFood)
                .orderBy(Expressions.numberTemplate(Double.class, "function('rand')").asc());
    }
}
