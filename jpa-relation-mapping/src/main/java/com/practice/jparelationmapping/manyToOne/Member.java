package com.practice.jparelationmapping.manyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


}
