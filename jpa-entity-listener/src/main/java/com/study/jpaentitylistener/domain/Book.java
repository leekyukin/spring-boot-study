package com.study.jpaentitylistener.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.study.jpaentitylistener.domain.listener.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners( value = AuditingEntityListener.class)
// EntityListener 로 Listener 클레스를 맵핑 시킴
// AuditingEntityListener : @CreatedDate 와 @LastModifiedDate
// 같은 어노테이션을 제공해 자동으로 생성시간과 수정시간을 저장할 수 있다.션
// 위 클레스로 Auditing 을 사용하려면 main 에서 @EnableJpaAuditing 으로
// Auditing 을 허용해 주어야 한다.
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    private Long publisherId;

    @OneToOne(mappedBy = "BookReviewInfo")
    private BookReviewInfo bookReviewInfo;


}
