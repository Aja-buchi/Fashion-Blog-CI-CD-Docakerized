package com.buchibanton.fashionblog.repository;

import com.buchibanton.fashionblog.model.Admin;
import com.buchibanton.fashionblog.model.Post;
import com.buchibanton.fashionblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByEmail(String email);

    Optional<Post> findPostByAdminId(Long adminId);
}
