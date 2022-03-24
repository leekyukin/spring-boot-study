package com.kujin.japfkpractice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OtherTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void otherTest() {

        // 갯수
        long count = userRepository.count();

        System.out.println("number of users : " + count);

        // 특정 엔티티가 존재하는지 확인
        boolean exists = userRepository.existsById(1L);

        System.out.println("Whether a user whose ID is 1 : " + exists);
    }
}
