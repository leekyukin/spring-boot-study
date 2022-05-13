package com.practice.jparelationmapping.oneToOne;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long computer_id;

    private String productName;

    @OneToOne(mappedBy = "computer")
    // Student 클레스의 computer 맴버와 매핑
    private Student student;
}
