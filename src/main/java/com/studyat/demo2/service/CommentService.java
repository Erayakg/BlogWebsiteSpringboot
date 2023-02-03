package com.studyat.demo2.service;

import com.studyat.demo2.entities.Comment;
import com.studyat.demo2.entities.Post;
import com.studyat.demo2.entities.User;
import com.studyat.demo2.repository.ICommentRepository;
import com.studyat.demo2.repository.IPostRepository;
import com.studyat.demo2.repository.IUserRepository;
import com.studyat.demo2.request.CommentCreateRequest;
import com.studyat.demo2.request.CommentUpdateRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    private ICommentRepository iCommentRepository;
    private IUserRepository iUserRepository;
private  PostService postService;

    public CommentService(ICommentRepository iCommentRepository, IUserRepository iUserRepository, PostService postService) {
        this.iCommentRepository = iCommentRepository;
        this.iUserRepository = iUserRepository;
        this.postService = postService;
    }

    @Override
    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return iCommentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return iCommentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return iCommentRepository.findByPostId(postId.get());
        } else
            return iCommentRepository.findAll();
    }

    @Override
    public Comment deleteByCommentId(Long commentId) {
        iCommentRepository.deleteById(commentId);
        return null;
    }
    @Override
    public List<Comment> getOneCommentById(Long commentId) {
        return iCommentRepository.findCommentById(commentId);
    }
    @Override
    public Comment addComment(Long postId, CommentCreateRequest commentCreateRequest) {

        User user = iUserRepository.getUserById(commentCreateRequest.getUserId());
        Post post = postService.getOnePost(commentCreateRequest.getPostId());

        if (user != null && post != null) {
            Comment commmentToSave = new Comment();
            commmentToSave.setPost(post);
            commmentToSave.setUser(user);
            commmentToSave.setText(commentCreateRequest.getTxt());
            return iCommentRepository.save(commmentToSave);
        } else
            return null;
    }
    @Override
    public Comment UpdateComment(Long CommentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = iCommentRepository.findById(CommentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(commentToUpdate.getText());
            return iCommentRepository.save(commentToUpdate);

        } else
            return null;
    }
}
