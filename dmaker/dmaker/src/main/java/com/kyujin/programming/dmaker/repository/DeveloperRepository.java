package com.kyujin.programming.dmaker.repository;

import com.kyujin.programming.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends
        JpaRepository<Developer, Long> {


}
