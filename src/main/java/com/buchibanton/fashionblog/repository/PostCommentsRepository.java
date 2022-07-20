package com.buchibanton.fashionblog.repository;

import com.buchibanton.fashionblog.model.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostCommentsRepository extends JpaRepository<PostComments, Long> {
    Optional<PostComments> findPostCommentsByCommentIdAndMessage(Long commentId, String message);
}
