package com.buchibanton.fashionblog.service;

import com.buchibanton.fashionblog.dto.*;
import com.buchibanton.fashionblog.model.*;

import java.util.List;

public interface AdminService {

    List<PostLikes> fetchLikes();
    List<PostComments> fetchComments();
    List<Post> findAllPost();
    Admin login(AdminSignUpDto adminSignUpDto);
    Post creatPost(PostDto postDto);
    Post updatePost(UpdatePostDto updatePostDto, Long id);
    void deletePost(Long id);
}
