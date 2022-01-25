package com.kyujin.programming.dmaker.repository;

import com.kyujin.programming.dmaker.code.StatusCode;
import com.kyujin.programming.dmaker.entity.Developer;
import com.kyujin.programming.dmaker.entity.RetiredDeveloper;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends
        JpaRepository<Developer, Long> {


    Optional<Developer> findByMemberId(String memberId);

    List<Developer> findDeveloperByStatusCodeEquals(StatusCode statusCode);
}
