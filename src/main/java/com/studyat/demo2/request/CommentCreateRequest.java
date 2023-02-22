package com.studyat.demo2.request;

import com.studyat.demo2.entities.Post;
import lombok.Data;

@Data
public class CommentCreateRequest {
    private Long id;
    private Long userId;
    private Long postId;
    private String txt;
}
