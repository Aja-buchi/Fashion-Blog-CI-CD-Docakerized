package com.buchibanton.fashionblog.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity @Builder
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;

    private String title;
    private String description;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;

    private LocalDateTime deletedDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private Admin admin1;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private User user1;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    private List<PostLikes> postLikes;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "posts")
    private List<PostComments> postComments;
}
