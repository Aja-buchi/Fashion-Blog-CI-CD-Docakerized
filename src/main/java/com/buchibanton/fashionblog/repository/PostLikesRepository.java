package com.buchibanton.fashionblog.repository;

import com.buchibanton.fashionblog.model.PostLikes;
import com.buchibanton.fashionblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostLikesRepository extends JpaRepository<PostLikes, Long> {
    Optional<PostLikes> findPostLikesByLikeId(Long likeId);
}
