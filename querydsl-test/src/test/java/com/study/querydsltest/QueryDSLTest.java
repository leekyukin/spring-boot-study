package com.study.querydsltest;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsltest.domain.FoodStore;
import com.study.querydsltest.domain.FoodType;
import com.study.querydsltest.domain.QFoodStore;
import com.study.querydsltest.domain.QFoodType;
import com.study.querydsltest.domain.repository.FoodStoreRepository;
import com.study.querydsltest.domain.repository.FoodTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.study.querydsltest.domain.QFoodStore.*;
import static com.study.querydsltest.domain.QFoodType.*;

@SpringBootTest
public class QueryDSLTest {

    @Autowired
    FoodTypeRepository foodTypeRepository;
    @Autowired
    FoodStoreRepository foodStoreRepository;
    @Autowired
    JPAQueryFactory query;

    @Test
    public void setData() {
        FoodType korean = new FoodType("한식", 1);
        FoodType western = new FoodType("양식", 2);
        FoodType chinese = new FoodType("중식", 3);

        foodTypeRepository.saveAll(List.of(korean, western, chinese));

        FoodStore foodStore1 = new FoodStore("삼겹살", 9, "sangmessi", korean);
        FoodStore foodStore2 = new FoodStore("닭갈비", 2, "sangmessi", korean);
        FoodStore foodStore3 = new FoodStore("부대찌개", 3, "lake", korean);
        FoodStore foodStore4 = new FoodStore("순대국밥", 4, "lake", korean);
        FoodStore foodStore5 = new FoodStore("소고기", 5, "lake", korean);
        FoodStore foodStore6 = new FoodStore("스파게티", 6, "sangmessi", western);
        FoodStore foodStore7 = new FoodStore("피자", 7, "sangmessi", western);
        FoodStore foodStore8 = new FoodStore("중국집", 8, "hong", chinese);
        FoodStore foodStore9 = new FoodStore("중국집2", 9, "hong", chinese);
        FoodStore foodStore10 = new FoodStore("중국집3", 10, "hong", chinese);

        foodStoreRepository.saveAll(List.of(foodStore1, foodStore2, foodStore3, foodStore4, foodStore5, foodStore6, foodStore7, foodStore8, foodStore9, foodStore10));

    }

    @Test
    public void 기본쿼리() {
        List<FoodStore> results = query
                .selectFrom(foodStore)
                .fetch();

        Assertions.assertEquals(results.size(), 10);
    }

    @Test
    public void 기본쿼리_조건절() {
        List<FoodStore> results = query
                .selectFrom(foodStore)
                .where(
                        foodStore.rate.goe(5),   // 조건문 연장 (.or()이나 .and()있음) "," 사용시 .and()로 인식
                        foodStore.storeName.startsWith("삼")
                )
                .fetch();

        Assertions.assertEquals(results.size(), 1);
    }

    @Test
    public void 기본쿼리_정렬() {
        List<FoodStore> results = query
                .selectFrom(foodStore)
                .orderBy(foodStore.rate.desc())
                .fetch();

        Assertions.assertEquals(results.size(), 10);
    }

    @Test
    public void 기본쿼리_페이징() {
        QueryResults<FoodStore> fetchResults = query
                .selectFrom(foodStore)
                .offset(0)  // 첫번쨰 페이지
                .limit(3)
                .fetchResults();

        List<FoodStore> results = fetchResults.getResults();
        long limit = fetchResults.getLimit();
        long offset = fetchResults.getOffset();
        long total = fetchResults.getTotal();

        System.out.println("result: " + results);
        System.out.println("limit: " + limit);
        System.out.println("offset: " + offset);
        System.out.println("total: " + total);
    }

    @Test
    public void join() {
        List<FoodStore> fetch = query
                .selectFrom(foodStore)
                .join(foodStore.foodType, foodType)
                .fetch();

        fetch.forEach(System.out::println);
    }

    @Test
    public void 연관관계_없는_조인() {
        List<FoodStore> results = query
                .select(foodStore)
                .from(foodStore, foodType)
                .where(foodStore.rate.eq(foodType.foodOrder))
                .fetch();

        Assertions.assertEquals(results.size(), 2);
    }

}