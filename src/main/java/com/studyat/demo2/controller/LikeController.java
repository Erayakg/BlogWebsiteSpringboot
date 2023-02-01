package com.studyat.demo2.controller;

import com.studyat.demo2.entities.Like;
import com.studyat.demo2.service.ILikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/like")
public class LikeController {
    private ILikeService iLikeService;
    public LikeController(ILikeService iLikeService) {
        this.iLikeService = iLikeService;
    }
    @GetMapping
    public List<Like> getLikes(Optional<Long> userId,Optional<Long> PostId){
        return iLikeService.getAllLikesWithParam(PostId,userId);
    }
    @GetMapping("/LikeId")
    public List<Like> getLikesByLikeId(Optional<Long> LikeId){
        return iLikeService.getLikeByLikeId(LikeId);
    }


}
