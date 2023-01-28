package com.studyat.demo2.service;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.studyat.demo2.entities.Post;
import com.studyat.demo2.entities.User;
import com.studyat.demo2.request.PostCreateRequest;
import com.studyat.demo2.request.PostUpdateRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.tags.Param;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getAllPost(@RequestParam Optional<Long> userId);
    Post getOnePost(Long id);
    Post Save(PostCreateRequest postCreateRequest);
    void deletePost(Long id);
    Post updateOnePost(Long postId, PostUpdateRequest updateRequest);

    void delete(Long postId);


}
