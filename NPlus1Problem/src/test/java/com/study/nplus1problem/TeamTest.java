package com.study.nplus1problem;

import com.study.nplus1problem.domain.Member;
import com.study.nplus1problem.domain.Team;
import com.study.nplus1problem.domain.repository.TeamRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeamTest {

    @Autowired
    TeamRepository teamRepository;

    // fetch = FetchType.EAGER : Team 가져올때 연관관계 매핑되어있는 members 까지 한 번에 전부 조회
    // fetch = FetchType.LAZY : Team 가져올때 Team 만 조회, 후에 members 값을 요구하면 그 때 members 조회

    @Test
    @Order(1)
    void normalJoinTest() {
        // N+1 문제 발생
        List<Team> teams = teamRepository.findTeamJoinMembers();

        for ( Team team : teams ) {
            System.out.println("========"+team.getName()+"========");

            for ( Member member : team.getMembers() ) {
                System.out.println("member.getClass() : "+member.getClass());
                System.out.println("member.getName() : "+member.getName());
            }

            System.out.println("==================================");
        }
    }

    @Test
    @Order(2)
    void findAll() {
        // 기본 JpaRepository 에서 제공하는 findAll()은 N+1 문제 발생
        List<Team> teams = teamRepository.findAll();

        for ( Team team : teams ) {
            System.out.println("========"+team.getName()+"========");
        }
    }

    @Test
    @Order(3)
    void findAllAndMemberNameTest() {
        List<Team> teams = teamRepository.findAll();

        for ( Team team : teams ) {
            System.out.println("========"+team.getName()+"========");

            for ( Member member : team.getMembers() ) {
                System.out.println("member.getClass() : "+member.getClass());
                System.out.println("member.getName() : "+member.getName());
            }

            System.out.println("==================================");
        }
    }

    @Test
    @Order(4)
    void fetchJoinTest() {
        List<Team> teams = teamRepository.findAllByQuery();

        for ( Team team : teams ) {
            System.out.println("========"+team.getName()+"========");

            for ( Member member : team.getMembers() ) {
                System.out.println("member.getClass() : "+member.getClass());
                System.out.println("member.getName() : "+member.getName());
            }

            System.out.println("==================================");
        }
    }

    @Test
    @Order(5)
    void entityGraphTest() {
        List<Team> teams = teamRepository.findAll();

        for ( Team team : teams ) {
            System.out.println("========"+team.getName()+"========");

            for ( Member member : team.getMembers() ) {
                System.out.println("member.getClass() : "+member.getClass());
                System.out.println("member.getName() : "+member.getName());
            }

            System.out.println("==================================");
        }
    }
}
