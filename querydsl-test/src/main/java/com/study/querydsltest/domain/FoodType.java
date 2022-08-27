package com.study.querydsltest.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"id", "foodTypeName", "foodOrder"})
public class FoodType {

    @Id
    @GeneratedValue
    @Column(name = "food_type_id")
    private Integer id;

    @Column(unique = true)
    private String foodTypeName;
    private int foodOrder;

    @OneToMany(mappedBy = "foodType")
    List<FoodStore> foodStoreList = new ArrayList<>();


    public FoodType(String foodTypeName, int foodOrder) {
        this.foodTypeName = foodTypeName;
        this.foodOrder = foodOrder;
    }
}
