package com.example.order.domain;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {


    // 스프링에서 지원하는 @CreatedDate, LastModifiedDate는 ZonedDateTime을 지원하지 않는다.

    @CreationTimestamp
    private ZonedDateTime createAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
