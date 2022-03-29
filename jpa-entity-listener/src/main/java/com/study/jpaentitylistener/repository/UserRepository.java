package com.study.jpaentitylistener.repository;



import com.study.jpaentitylistener.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
