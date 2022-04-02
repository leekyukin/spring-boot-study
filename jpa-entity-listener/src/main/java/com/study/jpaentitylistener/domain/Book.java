package com.study.jpaentitylistener.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Book implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    @CreatedDate
    private LocalDateTime createdAt;    // lombok 의 @Data 어노테이션으로 Auditable 의 메소드를 상속받는다.

    @LastModifiedDate
    private LocalDateTime updatedAt;    // lombok 의 @Data 어노테이션으로 Auditable 의 메소드를 상속받는다.

//    @PrePersist
//    public void prePersist() {
//        setCreatedAt(LocalDateTime.now());
//        setUpdateAt(LocalDateTime.now());
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        setUpdateAt(LocalDateTime.now());
//    }
}
