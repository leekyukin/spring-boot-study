package com.kyukiin.usermanagementsystem.repository;

import com.kyukiin.usermanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
