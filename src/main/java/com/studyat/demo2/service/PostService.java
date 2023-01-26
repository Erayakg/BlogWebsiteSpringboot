package com.studyat.demo2.service;

import com.studyat.demo2.repository.IPostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{
    private IPostRepository iPostRepository;

    public PostService(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }


}
