package com.study.jpaentitylistener.domain;

import com.study.jpaentitylistener.domain.listener.Auditable;
import com.study.jpaentitylistener.domain.listener.MyEntityListeners;
import com.study.jpaentitylistener.domain.listener.UserEntityListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners( value = {MyEntityListeners.class, UserEntityListener.class})
// EntityListener 로 Listener 클레스를 맵핑 시킴
public class User implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    // Auto 값은 enum 의 각각을 인덱스로 지정해서 잠재적 오류의 대상이다.
    // 그래서 enum 을 String 으로 인식하게 끔 한다.
    private Sex sex;

    private LocalDateTime createdAt;    // lombok 의 @Data 어노테이션으로 Auditable 의 메소드를 상속받는다.

    private LocalDateTime updatedAt;    // lombok 의 @Data 어노테이션으로 Auditable 의 메소드를 상속받는다.


//    @PrePersist
//    public void prePersist() {
//        setCreatedAt(LocalDateTime.now());
//        setUpdatedAt(LocalDateTime.now());
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        setUpdatedAt(LocalDateTime.now());
//    }
}
