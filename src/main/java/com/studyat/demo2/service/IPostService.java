package com.studyat.demo2.service;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.studyat.demo2.entities.Post;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

public interface IPostService {
    List<Post> getAllPost(Param);
}
