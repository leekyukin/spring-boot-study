package com.study.jpasortstudy.repository;

import com.study.jpasortstudy.demain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    // Last1 이 일반 문자열로 인식되어 findByName 과
    // 같은 쿼리문으로 동작하고, 같은 결과가 나온다.
    User findLast1ByName(String name);

    // Last1 과 같은 의미로 쿼리문을 작석아하면 아래와 같다.
    // 내림차순으로 정령한것의 맨 위
    User findTop1ByNameOrderByDesc(String name);



}
