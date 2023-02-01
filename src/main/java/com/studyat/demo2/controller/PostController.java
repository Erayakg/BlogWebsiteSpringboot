package com.studyat.demo2.controller;

import com.studyat.demo2.entities.Post;
import com.studyat.demo2.request.PostCreateRequest;
import com.studyat.demo2.request.PostUpdateRequest;
import com.studyat.demo2.response.PostResponse;
import com.studyat.demo2.service.IPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    private IPostService iPostService;

    public PostController(IPostService iPostService) {
        this.iPostService = iPostService;
    }

    @GetMapping
    public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId) {
        return iPostService.getAllPost(userId);

    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long Userid) {
        return iPostService.getOnePost(Userid);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
        return iPostService.Save(newPostRequest);
    }

    @PostMapping("/delete/{PostId}")
    public void deletePost(@PathVariable(name = "PostId") Long id) {
        iPostService.deletePost(id);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest) {
        return iPostService.updateOnePost(postId, postUpdateRequest);
    }


}
