package com.study.jpasortstudy.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

@SpringBootTest
class SortTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void sort() {

        String name = "moon";

        System.out.println("findLast1ByName : " + userRepository.findLast1ByName(name));

        System.out.println("findTop1ByNameOrderByIdDesc : " + userRepository.findTop1ByNameOrderByIdDesc(name) );

        System.out.println("findFirst1ByNameOrderByIdDescEmailAsc : " + userRepository.findFirst1ByNameOrderByIdDescEmailAsc(name));

        // 위의 쿼리와 같은 뜻이지만 훨씬 간편하고 가독성이 뛰어나고 활용성도 높다.
        System.out.println("findFirstByNameWithSortParams : " +
                userRepository.findFirstByName("leekujin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
    }
}
