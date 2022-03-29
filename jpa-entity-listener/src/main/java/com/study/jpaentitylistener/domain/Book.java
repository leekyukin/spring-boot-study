package com.study.jpaentitylistener.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners( value = MyEntityListeners.class)
// EntityListener 로 Listener 클레스를 맵핑 시킴
public class Book implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String author;

    private LocalDateTime createdAt;    // lombok 의 @Data 어노테이션으로 Auditable 의 메소드를 상속받는다.

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
