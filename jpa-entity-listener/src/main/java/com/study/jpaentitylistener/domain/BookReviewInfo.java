package com.study.jpaentitylistener.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class BookReviewInfo extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private Long bookId;

    private float averageReviewScore;

    private int reviewCount;
}
