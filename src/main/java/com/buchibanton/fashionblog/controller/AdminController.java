package com.buchibanton.fashionblog.controller;

import com.buchibanton.fashionblog.dto.AdminSignUpDto;
import com.buchibanton.fashionblog.dto.PostDto;
import com.buchibanton.fashionblog.dto.UpdatePostDto;
import com.buchibanton.fashionblog.model.Post;
import com.buchibanton.fashionblog.model.PostComments;
import com.buchibanton.fashionblog.model.PostLikes;
import com.buchibanton.fashionblog.model.pageCriterias.PostPage;
import com.buchibanton.fashionblog.repository.AdminRepository;
import com.buchibanton.fashionblog.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(adminService.creatPost(postDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestBody AdminSignUpDto adminSignUpDto){
        return new ResponseEntity<>(adminService.login(adminSignUpDto), HttpStatus.OK);
    }

    @PostMapping("/updatePost")
    public ResponseEntity<Post> updatePost(@RequestBody UpdatePostDto updatePostDto, Long postId){
        return new ResponseEntity<>(adminService.updatePost(updatePostDto, postId), HttpStatus.OK);
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id") Long postId){
        adminService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/fetchLikes")
    public ResponseEntity fetchLikes(){
        return new ResponseEntity<>(adminService.fetchLikes(), HttpStatus.OK);
    }

    @GetMapping("/fetchComments")
    public ResponseEntity fetchComments(){
        return new ResponseEntity<>(adminService.fetchComments(), HttpStatus.OK);
    }

    @GetMapping("/getAllPost")
    public ResponseEntity<Page<Post>> getAllPost(PostPage postPage){
        return new ResponseEntity<>(adminService.getAllPost(postPage), HttpStatus.OK);
    }
}
