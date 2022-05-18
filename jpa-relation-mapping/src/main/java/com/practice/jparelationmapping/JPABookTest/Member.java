package com.practice.jparelationmapping.JPABookTest;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;
    private String street;
    private String zipcode;

    @ToString.Exclude
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();



}
