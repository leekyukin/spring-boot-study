package com.practice.jparelationmapping.boardTest;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "community_id")
    private Long communityId;

    private Long writer;
    private String type;
    private String title;
    private String content;
}
