package com.study.jpaentitylistener.repository;

import com.study.jpaentitylistener.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {


}
