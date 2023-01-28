package com.studyat.demo2.service;
import com.studyat.demo2.entities.Comment;
import com.studyat.demo2.request.CommentCreateRequest;
import com.studyat.demo2.request.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;
public interface ICommentService  {
     List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);
     List<Comment> getOneCommentById(Long commentId);
     Comment addComment(Long postId, CommentCreateRequest commentCreateRequest);
     Comment UpdateComment(Long CommentId, CommentUpdateRequest commentUpdateRequest);
     Comment deleteByCommentId(Long commentId);
}
