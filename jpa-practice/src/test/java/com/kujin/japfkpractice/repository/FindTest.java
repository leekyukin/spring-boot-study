package com.kujin.japfkpractice.repository;

import com.kujin.japfkpractice.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class FindTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void find() {

//                                              name 의 역순으로 정렬하는 객체  DESC(descending) : 내림차순
         List<User> users1 = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

//        Lists 는 assertj 애서 제공하는 테스트용 클레스다.
//        번거롭게 리스트 생성, 삽입할 필요없이 간단한 구문을 확용할 수 있게 해준다.

        List<User> users2 = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

        System.out.println("==============<<< LIST  >>>==============\n");

        User user1 = new User(6L, "leekujin", "leekujin@gmail.com");
        User user2 = new User(7L, "zang", "zang@gamil.com");

        // findById() 는 Optional<> 로 랩핑된 객체에 담아주어야 한다.
        Optional<User> OptionalUser =  userRepository.findById(1L);

        // 아니면 orElse() 를 사용한다.
        // orElse() : 값이 null 이면 매개변수의 값을 저장한다.
        User normalUser = userRepository.findById(6L).orElse(null);

        ArrayList<User> users = Lists.newArrayList(normalUser, user1, user2);

        users.forEach(System.out::println);
        System.out.println();
        System.out.println("=========================================\n");


    }
}
