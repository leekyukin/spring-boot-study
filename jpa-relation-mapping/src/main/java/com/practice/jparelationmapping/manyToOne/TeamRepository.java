package com.practice.jparelationmapping.manyToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
