package com.kujin.japfkpractice.repository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeleteTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {

        // 특정 엔티티 삭제

        // select 가 두 번 생김
        userRepository.delete(userRepository.findById(5L).orElseThrow(RuntimeException::new));
        userRepository.findAll().forEach(System.out::println);

        // select 한번
        userRepository.deleteById(7L);
        userRepository.findAll().forEach(System.out::println);



        userRepository.findAll().forEach(System.out::println);

        // 여러개 삭제
        // 성능상 문제 : find -> for loop 로 각각을 다 delete
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L,4L)));
        userRepository.findAll().forEach(System.out::println);

        // 성능 개선 : find -> delete 한 번
        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(2L, 6L)));
        userRepository.findAll().forEach(System.out::println);

        // 전부 삭제
        // 성능상 문제 : 모든 엔티티가 하나씩 for loop 로 삭제된다.
        userRepository.deleteAll();

        // 성능상 좋음 : 모든 엔티티가 한번에 삭제된다.
        userRepository.deleteAllInBatch();


    }
}