package com.study.nplus1problem.domain.repository;

import com.study.nplus1problem.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String name);
}
