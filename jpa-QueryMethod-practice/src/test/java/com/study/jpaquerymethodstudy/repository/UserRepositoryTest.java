package com.study.jpaquerymethodstudy.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void select() {

        // yml show-ddl 설정으로 쿼리문과 결과 값이 같이 충력됨으로 하나씩 주석 처리해가면서 비교해봐라~

        String name = "leekujin";
        String email = "leekujin@gmail.com";

//        System.out.println("findByName : " + userRepository.findByName(name));
//
//        System.out.println("findByEmail : " + userRepository.findByEmail(email));
//
//        System.out.println("getByEmail : " + userRepository.getByEmail(email));
//
//        System.out.println("readByEmail : " + userRepository.readByEmail(email));
//
//        System.out.println("queryByEmail : " + userRepository.queryByEmail(email));
//
//        System.out.println("searchByEmail : " + userRepository.searchByEmail(email));
//
//        System.out.println("streamByEmail : " + userRepository.streamByEmail(email));
//
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail(email));
//
//        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail(email));

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName(email, name));

        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName(email, name));


    }


}