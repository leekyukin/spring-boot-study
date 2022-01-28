package com.kyukiin.usermanagementsystem.repository;

import com.kyukiin.usermanagementsystem.entity.User;
import com.kyukiin.usermanagementsystem.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByNickName(String nickName);
    Optional<User> findByPw(String pw);

    List<User> findByStatusCode(StatusCode status);

}
