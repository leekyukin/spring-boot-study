package com.study.jpaentitylistener.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@EntityListeners(value = AuditingEntityListener.class)
// EntityListener 로 Listener 클레스를 맵핑 시킴
// AuditingEntityListener : @CreatedDate 와 @LastModifiedDate
// 같은 어노테이션을 제공해 자동으로 생성시간과 수정시간을 저장할 수 있다.
// 위 클레스로 Auditing 을 사용하려면 main 에서 @EnableJpaAuditing 으로
// Auditing 을 허용해 주어야 한다.
@MappedSuperclass
// 이 클레스의 맴버변수를 상속 받는 클레스의 맴버변수로 사용하게 해주는 어노테이션
public class BaseEntity {
    // 이 방법이 실무와 가장 가깝다.

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
