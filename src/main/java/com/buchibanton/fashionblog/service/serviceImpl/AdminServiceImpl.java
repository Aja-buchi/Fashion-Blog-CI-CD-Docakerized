package com.buchibanton.fashionblog.service.serviceImpl;

import com.buchibanton.fashionblog.dto.AdminSignUpDto;
import com.buchibanton.fashionblog.dto.PostDto;
import com.buchibanton.fashionblog.dto.UpdatePostDto;
import com.buchibanton.fashionblog.exceptions.PostNotFoundException;
import com.buchibanton.fashionblog.exceptions.UserNotFoundException;
import com.buchibanton.fashionblog.model.*;
import com.buchibanton.fashionblog.repository.*;
import com.buchibanton.fashionblog.service.AdminService;
import com.buchibanton.fashionblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    private final PostRepository postRepository;

    private final PostLikesRepository postLikesRepository;

    private final PostCommentsRepository postCommentsRepository;

    @Override
    public List<PostLikes> fetchLikes(){
        return postLikesRepository.findAll();
    }

    @Override
    public List<PostComments> fetchComments() {
        return postCommentsRepository.findAll();
    }

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Admin login(AdminSignUpDto adminSignUpDto) {
        return null;
    }

    @Override
    public Post creatPost(PostDto postDto) {
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(UpdatePostDto updatePostDto, Long postId) {
        Post post = postRepository.findPostByPostId(postId)
                .orElseThrow(() -> new PostNotFoundException("This post does not exist"));
        BeanUtils.copyProperties(updatePostDto, post);
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findPostByPostId(postId)
                .orElseThrow(()-> new PostNotFoundException("This post does not exist"));
        postRepository.delete(post);

    }
}
