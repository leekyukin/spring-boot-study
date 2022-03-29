package com.study.jpaentitylistener.repository;

import com.study.jpaentitylistener.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
