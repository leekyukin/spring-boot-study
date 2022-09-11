package com.study.nplus1problem.domain.repository;

import com.study.nplus1problem.domain.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String name);

    @EntityGraph(attributePaths = "members")
    List<Team> findAll();

    @Query("select t from Team t join fetch t.members")
    List<Team> findAllByQuery();

    @Query("select t from Team t join t.members")
    List<Team> findTeamJoinMembers();
}
