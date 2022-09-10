package com.study.nplus1problem.domain.repository;

import com.study.nplus1problem.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.team")
    List<Member> findMemberFetchJoin();

    @Query("select m from Member m join m.team")
    List<Member> findMemberJoin();

    @Override
    @EntityGraph(attributePaths = "team")
    List<Member> findAll();
}
