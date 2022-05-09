package com.kyukin.utillizingjpa1.repository;

import com.kyukin.utillizingjpa1.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    @Transactional // EntityManager 를 이용한 데이터 변경은 무조건 Transactional 이 있어야 한다.
//    @Rollback(value = false) // 실제 값을 보기 위해 롤백을 하지 않았다.
    // test 코드는 기본적으로 트랜잭션이 끝나면 롤백을 한다.
    public void test() throws Exception {
        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); // 영속성 컨텍스트에서 식별자가 같으면 같은 객체다.
        System.out.println(findMember == member);
    }
}