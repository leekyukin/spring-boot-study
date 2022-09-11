package com.study.nplus1problem;

import com.study.nplus1problem.domain.Member;
import com.study.nplus1problem.domain.repository.MemberRepository;
import com.study.nplus1problem.domain.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;


    // 쿼리 개수에 따라 부하가 걸림
    // 쿼리 하나당 한 번 네트워크 I/O 를 타기 때문.
    @Test
    void issueTest() {
        List<Member> members = memberRepository.findAll();

        // QueryMethod 는 team 에 프록시 객체 넣음 (걍 안넣음)
        // 그래서 team.getName()하면 다시 select team 을 함
        // 고로 쿼리 N + 1
        for ( Member member : members ) {
            System.out.println(member.getTeam().getName());
        }
    }


    @Test
    void normalJoinTest() {
        List<Member> members = memberRepository.findMemberJoin();

        // 일반 join 은 team 을 select 안함
        // 그래서 team 에 프록시 객체 있음
        // 그래서 team.getName()하면 다시 select team 을 함
        // 고로 쿼리 N + 1
        for (Member member : members) {
            System.out.println("team class : " +member.getTeam().getClass());
            System.out.println(member.getTeam().getName());
        }
    }


    @Test
    void queryTest() {
        List<Member> members = memberRepository.findMemberFetchJoin();

        // fetch join 은 team 까지 select 함
        // 그래서 team 에 진짜 객체 있음
        // 고로 쿼리 1개
        for ( Member member : members ) {
            System.out.println(member.getTeam().getName());
        }
    }

    @Test
    void entityGraphTest() {
        List<Member> members = memberRepository.findAll();

        // @EntityGraph 는 team 까지 select 함 (내부적으로 fetch join 과 같음)
        // 그래서 team 에 진짜 객체 있음
        // 고로 쿼리 1개
        for ( Member member : members ) {
            System.out.println(member.getTeam().getName());
        }
    }

    @Test
    void queryWithEntityGraphTest() {
        List<Member> members = memberRepository.findAllByQueryByEntityGraph();

        // @EntityGraph 는 team 까지 select 함 (내부적으로 fetch join 과 같음)
        // 그래서 team 에 진짜 객체 있음
        // 고로 쿼리 1개
        for ( Member member : members ) {
            System.out.println(member.getTeam().getName());
        }
    }
}
