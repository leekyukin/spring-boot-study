package com.study.querydsltest.domain.repository;

import com.study.querydsltest.domain.FoodStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodStoreRepository extends JpaRepository<FoodStore, Integer> {
}
