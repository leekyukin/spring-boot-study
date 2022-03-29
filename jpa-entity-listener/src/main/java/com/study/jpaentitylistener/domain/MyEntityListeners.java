package com.study.jpaentitylistener.domain;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListeners {

    @PrePersist // DB 쿼리 실행전에 작동하는 함수
    public void prePersist(Object o) {  // 자신의 맴버가 없기 때문에 객체를 받는다.
        if (o instanceof Auditable) {    // o 가 Auditable 이거나 상속 받았으면 true
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate  // Update 전에 실행되는 함수
    public void preUpdate(Object o) {
        if (o instanceof Auditable) {
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }

}
