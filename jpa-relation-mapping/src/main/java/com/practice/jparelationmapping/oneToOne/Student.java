package com.practice.jparelationmapping.oneToOne;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "computer_id")
    // Computer 클레스의 computer_id
    private Computer computer;
}
