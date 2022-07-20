package com.buchibanton.fashionblog.service;

import com.buchibanton.fashionblog.dto.PostCommentsDto;
import com.buchibanton.fashionblog.dto.PostDto;
import com.buchibanton.fashionblog.dto.PostLikesDto;
import com.buchibanton.fashionblog.dto.UserSignUpDto;
import com.buchibanton.fashionblog.model.Post;
import com.buchibanton.fashionblog.model.PostComments;
import com.buchibanton.fashionblog.model.PostLikes;
import com.buchibanton.fashionblog.model.User;

import java.util.List;

public interface UserService {
    User signUp(UserSignUpDto userSignUpDto);
    User login(UserSignUpDto userSignUpDto);
    String logout();
    Post viewPost(Long id);
    List<Post> getAllPost();
    User fetchUser(Long id);
    PostLikes likes(PostLikesDto postLikesDto);
    PostComments comments(PostCommentsDto postCommentsDto);
}
