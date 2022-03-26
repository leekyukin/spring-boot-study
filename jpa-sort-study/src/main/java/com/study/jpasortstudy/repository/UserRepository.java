package com.study.jpasortstudy.repository;

import com.study.jpasortstudy.demain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    // Last1 이 일반 문자열로 인식되어 findByName 과
    // 같은 쿼리문으로 동작하고, 같은 결과가 나온다.
    User findLast1ByName(String name);

    // Last1 과 같은 의미로 쿼리문을 작석아하면 아래와 같다.
    // 아이디로 내림차순 정령한것의 맨 위 히니
    User findTop1ByNameOrderByIdDesc(String name);

    // Id 는 내림차순, email 은 오름차순으로 정령한 값의 맨 위 하나
    User findFirst1ByNameOrderByIdDescEmailAsc(String name);

    // 위와 같은 뜻으로 사용할 수 있지만 훨씬 가독성이 뛰어나고 활용성도 높다.
    User findFirstByName(String name, Sort sort);
}
