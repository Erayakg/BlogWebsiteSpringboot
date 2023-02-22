package com.studyat.demo2.response;

import com.studyat.demo2.entities.Comment;
import com.studyat.demo2.entities.Post;
import lombok.Data;

@Data

public class CommentResponse {

    private Long id;
    private Post post;
    private String commentTxt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.post = comment.getPost();
        this.commentTxt = comment.getCommentTxt();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getCommentTxt() {
        return commentTxt;
    }

    public void setCommentTxt(String commentTxt) {
        this.commentTxt = commentTxt;
    }
}
