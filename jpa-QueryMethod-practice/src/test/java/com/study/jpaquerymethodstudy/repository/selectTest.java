package com.study.jpaquerymethodstudy.repository;

import com.study.jpaquerymethodstudy.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
class SelectTest {

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
//
//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName(email, name));
//
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName(email, name));
//
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(5L)));
//
//
//
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(9L));
//
//        System.out.println("findByIdGreaterThan : " + userRepository.findByIdGreaterThan(9L));
//
//        System.out.println("findByIdGreaterThanEqual : " + userRepository.findByIdGreaterThanEqual(9L));
//
//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 2L));
//
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 2L));

//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("lee", "yoon", "moon")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("l"));

        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("n"));

        System.out.println("findByNameContains : " + userRepository.findByNameContains("e"));

        System.out.println("findByNameLike : " + userRepository.findByNameLike("%o%"));
    }
}