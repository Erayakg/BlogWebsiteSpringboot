package com.studyat.demo2.service;

import com.studyat.demo2.entities.Comment;
import com.studyat.demo2.entities.Like;
import com.studyat.demo2.entities.Post;
import com.studyat.demo2.entities.User;
import com.studyat.demo2.repository.ILikeRepository;
import com.studyat.demo2.repository.IUserRepository;
import com.studyat.demo2.request.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService implements ILikeService {
    private ILikeRepository iLikeRepository;
    private  IPostService iPostService;
    private IuserService iuserService;

    public LikeService(ILikeRepository iLikeRepository, IPostService iPostService, IuserService iuserService) {
        this.iLikeRepository = iLikeRepository;
        this.iPostService = iPostService;
        this.iuserService = iuserService;
    }

    @Override
    public List<Like> getAllLikesWithParam(Optional<Long> postId, Optional<Long> userId) {
        if (postId != null && userId != null) {
            return iLikeRepository.findByUserIdAndPostId(userId, postId);
        } else if (postId != null) {
            return iLikeRepository.findByPostId(postId);
        } else if (userId != null) {
            return iLikeRepository.findByUserId(userId);
        }
        return iLikeRepository.findAll();
    }
    @Override
    public List<Like> getLikeByLikeId(Optional<Long> LikeId) {
        return iLikeRepository.findLikeById(LikeId);
    }

    @Override
    public Like createLike(LikeCreateRequest likeCreateRequest) {
        User user = iuserService.getByUserId(likeCreateRequest.getUserId());
        Post post =iPostService.getOnePost(likeCreateRequest.getPostId());
        if (user!=null && post!=null){
            Like saveLike=new Like();
            saveLike.setId(likeCreateRequest.getId());
            return iLikeRepository.save(saveLike);
        }
        return null;
    }
}

