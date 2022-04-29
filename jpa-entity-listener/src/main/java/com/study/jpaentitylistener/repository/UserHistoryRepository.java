package com.study.jpaentitylistener.repository;


import com.study.jpaentitylistener.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
