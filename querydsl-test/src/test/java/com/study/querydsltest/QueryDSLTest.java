package com.study.querydsltest;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsltest.domain.FoodStore;
import com.study.querydsltest.domain.FoodType;
import com.study.querydsltest.domain.QFoodStore;
import com.study.querydsltest.domain.repository.FoodStoreRepository;
import com.study.querydsltest.domain.repository.FoodTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QueryDSLTest {

    @Autowired
    FoodTypeRepository foodTypeRepository;
    @Autowired
    FoodStoreRepository foodStoreRepository;
    @Autowired
    JPAQueryFactory query;

    @BeforeEach
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
                .selectFrom(QFoodStore.foodStore)
                .fetch();

        Assertions.assertEquals(results.size(), 10);
    }

    @Test
    public void 
}