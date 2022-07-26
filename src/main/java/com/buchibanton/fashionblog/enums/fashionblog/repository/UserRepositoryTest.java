//package com.buchibanton.fashionblog.enums.fashionblog.repository;
//
//import com.buchibanton.fashionblog.model.User;
//import com.buchibanton.fashionblog.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    void findByEmail() {
//        Optional<User> user = userRepository.findByEmail("nazking@gmail.com");
//        System.out.println("user = " + user);
//    }
//
//    @Test
//    void existsByEmail() {
//        boolean email = userRepository.existsByEmail("idowutosin@gmail.com");
//        System.out.println("email = " + email);
//    }
//
//    @Test
//    void findUsersByUserId() {
////        User user = userRepository.findUsersByUserId(1L).get();
////        assertEquals(user.getUserName(), "tosin");
//        Optional<User> userId = userRepository.findUsersByUserId(1L);
//        System.out.println("userId = " + userId);
//    }
//}