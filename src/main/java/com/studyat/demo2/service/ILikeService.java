package com.studyat.demo2.service;

import com.studyat.demo2.entities.Comment;
import com.studyat.demo2.entities.Like;
import com.studyat.demo2.request.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface ILikeService {
    List<Like> getAllLikesWithParam(Optional<Long> postId,Optional<Long> userId);
    List<Like> getLikeByLikeId(Optional<Long> LikeId );
    Like createLike(LikeCreateRequest likeCreateRequest);


}
