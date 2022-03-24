package com.kujin.japfkpractice.repository;

import com.kujin.japfkpractice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
