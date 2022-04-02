package com.study.jpaentitylistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
// Auditing 을 허용하는 어노테이션
public class JpaEntityListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEntityListenerApplication.class, args);
    }

}
