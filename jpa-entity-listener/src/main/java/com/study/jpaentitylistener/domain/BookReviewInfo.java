package com.study.jpaentitylistener.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
// 부모 클레스의 필드까지 EqualsAndHashCode 를 적용한다.
@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class BookReviewInfo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long bookId;

    @OneToOne(optional = false)
    // book 은 null 을 허용하지 않음
    private Book book;

    // 기본형 타입(Primitive type) 으로 선언한 이유
    // 프리미티브 타입은 null 값을 넣을 수 없다.
    // 아래 두 값은 null 값 대신 0 을 넣기 위해
    // 프리미티브 타입으로 선언했다.
    private float averageReviewScore;

    private int reviewCount;
}
