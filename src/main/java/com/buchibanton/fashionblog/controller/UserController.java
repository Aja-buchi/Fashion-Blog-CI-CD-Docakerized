package com.buchibanton.fashionblog.controller;

import com.buchibanton.fashionblog.dto.PostCommentsDto;
import com.buchibanton.fashionblog.dto.PostLikesDto;
import com.buchibanton.fashionblog.dto.UserSignUpDto;
import com.buchibanton.fashionblog.exceptions.UserNotFoundException;
import com.buchibanton.fashionblog.model.Post;
import com.buchibanton.fashionblog.model.User;
import com.buchibanton.fashionblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<User> userSignUp(@RequestBody UserSignUpDto userSignUpDto){
        return new ResponseEntity<>(userService.signUp(userSignUpDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody UserSignUpDto userSignUpDto){
        return new ResponseEntity<>(userService.login(userSignUpDto), HttpStatus.OK);
    }

    @GetMapping("/fetchUsers/{id}")
    public ResponseEntity<User> fetchUsers(@PathVariable("id") Long userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.fetchUser(userId), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        return new ResponseEntity<>(userService.logout(), HttpStatus.OK);
    }

    @GetMapping("/viewPost/{id}")
    public ResponseEntity<Post> viewPost(@PathVariable("id") Long userId){
        return new ResponseEntity<>(userService.viewPost(userId), HttpStatus.OK);
    }

    @PostMapping("/likes")
    public ResponseEntity<String> likes(@RequestBody PostLikesDto postLikesDto){
        return new ResponseEntity<>(userService.likes(postLikesDto), HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<String> comments(@RequestBody PostCommentsDto postCommentsDto){
        return new ResponseEntity<>(userService.comments(postCommentsDto), HttpStatus.OK);
    }
}
