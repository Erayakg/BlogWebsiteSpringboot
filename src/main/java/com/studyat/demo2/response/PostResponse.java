package com.studyat.demo2.response;

import com.studyat.demo2.entities.Post;
import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private Long UserId;
    private String UserName;
    private String txt;
    private String title;
    public PostResponse(Post post) {
        this.id = post.getId();
        UserId = post.getUser().getId();
        UserName = post.getUser().getUserName();
        this.txt = post.getTxt();
        this.title = post.getTitle();
    }
}
