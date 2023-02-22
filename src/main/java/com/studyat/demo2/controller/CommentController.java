package com.studyat.demo2.controller;

import com.studyat.demo2.entities.Comment;
import com.studyat.demo2.entities.Post;
import com.studyat.demo2.repository.ICommentRepository;
import com.studyat.demo2.request.CommentCreateRequest;
import com.studyat.demo2.request.CommentUpdateRequest;
import com.studyat.demo2.response.CommentResponse;
import com.studyat.demo2.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private ICommentService iCommentService;

    public CommentController(ICommentService iCommentService) {
        this.iCommentService = iCommentService;
    }

    @GetMapping
    public List<CommentResponse> getAllComments(@RequestParam  Optional<Long> userId,
                                                @RequestParam  Optional<Long> postId) {
        return iCommentService.getAllCommentsWithParam(userId,postId);
    }
    @GetMapping("/{commentId}")
    public List<Comment> getOneComment(@PathVariable Long  commentId){
         return iCommentService.getOneCommentById(commentId);
    }
    @PostMapping("/{PostId}")
    public Comment createComment(@PathVariable Long PostId, @RequestBody CommentCreateRequest commentCreateRequest){
        return iCommentService.addComment(PostId,commentCreateRequest);
    }
    @PutMapping("/{CommentId}")
    public Comment updateComment(@PathVariable Long CommentId, @RequestBody CommentUpdateRequest updateRequest){
        return iCommentService.UpdateComment(CommentId,updateRequest);
    }
    @PostMapping("/delete/{commentId}")
    public Comment deleteByIdComment(@PathVariable Long commentId){
        return iCommentService.deleteByCommentId(commentId);
    }



}
