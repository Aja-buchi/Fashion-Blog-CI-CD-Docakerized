package com.buchibanton.fashionblog.repository;

import com.buchibanton.fashionblog.model.User;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RequiredArgsConstructor
class UserRepositoryTest {
    private  final UserRepository repository;

    @Test
    void findByEmail() {
//        User user =
    }

    @Test
    void existsByEmail() {
    }

    @Test
    void findUsersByUserId() {
    }
}