package com.kujin.japfkpractice.repository;

import com.kujin.japfkpractice.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaveTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveTest() {
        // 6L 에서 L 은 Long 을 뜻함
        User user1 = new User(6L, "leekujin", "leekujin@gmail.com");
        User user2 = new User(7L, "zang", "zang@gamil.com");

        // 성능상 문제 : for loop 로 save 여러번 발생
        userRepository.saveAll(Lists.newArrayList(user1, user2));

    }
}
