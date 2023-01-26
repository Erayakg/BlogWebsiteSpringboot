package com.studyat.demo2.repository;

import com.studyat.demo2.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepository extends JpaRepository<Like,Long> {
}
