package com.studyat.demo2.service;

import com.studyat.demo2.entities.Post;
import com.studyat.demo2.entities.User;
import com.studyat.demo2.repository.IPostRepository;
import com.studyat.demo2.request.PostCreateRequest;
import com.studyat.demo2.request.PostUpdateRequest;
import com.studyat.demo2.response.PostResponse;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{
    private IPostRepository iPostRepository;
    private IuserService iuserService;

    public PostService(IPostRepository iPostRepository, IuserService iuserService) {
        this.iPostRepository = iPostRepository;
        this.iuserService = iuserService;
    }

    @Override
    public List<PostResponse> getAllPost(Optional<Long> userId) {
        List<Post> list;
        if (userId.isPresent()){

           list=  iPostRepository.findByUserId(userId);

        }
        list= iPostRepository.findAll();
        return list.stream().map(p-> new PostResponse(p)).collect(Collectors.toList());
    }

    @Override
    public void deletePost(Long id) {
        iPostRepository.deleteById(id);
    }

    @Override
    public Post updateOnePost(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post =iPostRepository.findById(postId);
        if (post.isPresent()){
            Post toUpdate=post.get();
            toUpdate.setTxt(postUpdateRequest.getTxt());
            toUpdate.setTitle(postUpdateRequest.getTitle());
            iPostRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }
    @Override
    public void delete(Long postId) {
        iPostRepository.deleteById(postId);
    }

    @Override
    public Post getOnePost(Long id) {
        return iPostRepository.findById(id).orElse(null);
    }

    @Override
    public Post Save(PostCreateRequest postCreateRequest) {
    User user= iuserService.getByIdUser(postCreateRequest.getUserId());
    if (user==null){
        return null;
    }
    Post toSave=new Post();
    toSave.setId(postCreateRequest.getId());
    toSave.setTitle(postCreateRequest.getTitle());
    toSave.setTxt(postCreateRequest.getText());
    toSave.setTitle(postCreateRequest.getTitle());
    toSave.setUser(user);
    return iPostRepository.save(toSave);

    }
}
