package com.kyukin.hitmycousin.repository;

import com.kyukin.hitmycousin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaRepository<UserEntity, Long> {

}
