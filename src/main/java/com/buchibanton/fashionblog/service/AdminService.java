package com.buchibanton.fashionblog.service;

import com.buchibanton.fashionblog.dto.*;
import com.buchibanton.fashionblog.model.*;

import java.util.List;

public interface AdminService {

    List<PostLikes> fetchLikes();
    List<PostComments> fetchComments();
//    List<Post> findAllPost();
    String login(AdminSignUpDto adminSignUpDto);
    Post creatPost(PostDto postDto);
    List<Post> getAllPost();
    Post updatePost(UpdatePostDto updatePostDto, Long postId);
    void deletePost(Long postId);
}
