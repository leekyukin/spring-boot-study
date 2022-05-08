package com.practice.jparelationshippractice.repository;


import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UseRepository extends JpaRepository<User, Long> {
}
