package com.studyat.demo2.repository;

import com.studyat.demo2.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post,Long> {
}
