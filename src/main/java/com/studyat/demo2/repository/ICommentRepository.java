package com.studyat.demo2.repository;

import com.studyat.demo2.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Long>
{
}
