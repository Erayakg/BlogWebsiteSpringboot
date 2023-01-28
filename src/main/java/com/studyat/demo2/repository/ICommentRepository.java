package com.studyat.demo2.repository;

import com.studyat.demo2.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Long>
{
    List<Comment> findByUserIdAndPostId(Long userId,Long postId);

    List<Comment> findByUserId(Long userId);
    List<Comment> findByPostId(Long PostId);
    List<Comment> findCommentById(Long id);


}
