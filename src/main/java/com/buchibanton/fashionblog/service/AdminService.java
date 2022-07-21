package com.buchibanton.fashionblog.service;

import com.buchibanton.fashionblog.dto.*;
import com.buchibanton.fashionblog.model.*;
import com.buchibanton.fashionblog.model.pageCriterias.PostPage;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {

    List<PostLikes> fetchLikes();

    List<PostComments> fetchComments();

    String login(AdminSignUpDto adminSignUpDto);

    Post creatPost(PostDto postDto);

    Page<Post> getAllPost(PostPage postPage);

    Post updatePost(UpdatePostDto updatePostDto, Long postId);

    void deletePost(Long postId);
}
