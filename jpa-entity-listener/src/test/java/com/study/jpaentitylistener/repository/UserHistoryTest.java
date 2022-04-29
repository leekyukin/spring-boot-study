package com.study.jpaentitylistener.repository;

import com.study.jpaentitylistener.domain.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserHistoryTest {

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        User user = new User();

        user.setEmail("leiij@mallf.com");
        user.setName("mir");

        userRepository.save(user);
        user.setName("leejaemyeong");
        userRepository.save(user);
        userHistoryRepository.findAll().forEach(System.out::println);


    }

}
