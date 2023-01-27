package com.studyat.demo2.repository;

import com.studyat.demo2.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Optional<Long> userId);
}
