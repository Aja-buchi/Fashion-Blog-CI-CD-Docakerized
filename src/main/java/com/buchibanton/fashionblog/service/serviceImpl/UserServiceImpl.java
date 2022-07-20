package com.buchibanton.fashionblog.service.serviceImpl;

import com.buchibanton.fashionblog.dto.PostCommentsDto;
import com.buchibanton.fashionblog.dto.PostDto;
import com.buchibanton.fashionblog.dto.PostLikesDto;
import com.buchibanton.fashionblog.dto.UserSignUpDto;
import com.buchibanton.fashionblog.exceptions.UserAlreadyExists;
import com.buchibanton.fashionblog.exceptions.UserNotFoundException;
import com.buchibanton.fashionblog.model.Post;
import com.buchibanton.fashionblog.model.PostComments;
import com.buchibanton.fashionblog.model.PostLikes;
import com.buchibanton.fashionblog.model.User;
import com.buchibanton.fashionblog.repository.PostCommentsRepository;
import com.buchibanton.fashionblog.repository.PostLikesRepository;
import com.buchibanton.fashionblog.repository.PostRepository;
import com.buchibanton.fashionblog.repository.UserRepository;
import com.buchibanton.fashionblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final PostCommentsRepository postCommentsRepository;


    private final PostLikesRepository postLikesRepository;


    private final HttpSession httpSession;

    private final PostRepository postRepository;


    @Override
    public User signUp(UserSignUpDto userSignUpDto) {
        if(userRepository.existsByEmail(userSignUpDto.getEmail())){
            throw new UserAlreadyExists("User with " + userSignUpDto.getEmail() + " already exists");
        }
        else{
            User user = new User();
            BeanUtils.copyProperties(userSignUpDto, user);
            return userRepository.save(user);
        }
    }

    @Override
    public User login(UserSignUpDto userSignUpDto) {
        String email = userSignUpDto.getEmail();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
        if (!user.getPassword().equals(userSignUpDto.getPassword())){
            throw new UserNotFoundException("email or password not correct");
        }
        httpSession.setAttribute("id_exists", user.getUserId());
        httpSession.setAttribute("permission", "user");
        return user;
    }

    @Override
    public String logout() {
        httpSession.invalidate();
        return "Logged out";
    }

    @Override
    public Post viewPost(Long postId) {
        Optional<Post> optionalPost = postRepository.findPostByPostId(postId);
        if (optionalPost.isPresent()){
            return optionalPost.get();
        }
        else{
            throw new UserNotFoundException("Post with id " + postId + " not found");
        }
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public User fetchUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else{
            throw new UserNotFoundException("User with " + userId + " not found");
        }
    }
//*****************************************************
    @Override
    public PostLikes likes(PostLikesDto postLikesDto) {
        PostLikes postLikes = new PostLikes();
        return null;
    }

    @Override
    public PostComments comments(PostCommentsDto postCommentsDto) {
        return null;
    }
//    ****************************************************
}
