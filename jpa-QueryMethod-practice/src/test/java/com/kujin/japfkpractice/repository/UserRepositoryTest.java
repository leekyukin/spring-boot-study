package com.kujin.japfkpractice.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void select() {
        String email = "leekujin@gmail.com";

        System.out.println("findByName : " + userRepository.findByName("leekujin"));

        System.out.println("findByEmail : " + userRepository.findByEmail(email));

        System.out.println("getByEmail : " + userRepository.getByEmail(email));

        System.out.println("readByEmail : " + userRepository.readByEmail(email));

        System.out.println("queryByEmail : " + userRepository.queryByEmail(email));

        System.out.println("searchByEmail : " + userRepository.searchByEmail(email));

        System.out.println("streamByEmail : " + userRepository.streamByEmail(email));

        System.out.println("findUserByEmail : " + userRepository.findUserByEmail(email));

        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail(email));


    }

}