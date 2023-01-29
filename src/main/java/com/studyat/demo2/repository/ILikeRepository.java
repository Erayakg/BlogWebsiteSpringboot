package com.studyat.demo2.repository;

import com.studyat.demo2.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ILikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserIdAndPostId(Optional<Long> userId,Optional<Long> postId);
    List<Like> findByPostId(Optional<Long> postId);
    List<Like> findByUserId(Optional<Long> userId);
    List<Like> findLikeById(Optional<Long> LikeId );

}
