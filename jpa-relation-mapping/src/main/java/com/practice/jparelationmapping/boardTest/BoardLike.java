package com.practice.jparelationmapping.boardTest;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardLike extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "board_like_id")
    private Long boardLikeId;

    @Column(name = "board_id")
    private Long boardId;

    private Long liker;
}
