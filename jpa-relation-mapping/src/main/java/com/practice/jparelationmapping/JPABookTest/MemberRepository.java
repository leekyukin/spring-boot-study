package com.practice.jparelationmapping.JPABookTest;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.remote.JMXPrincipal;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
