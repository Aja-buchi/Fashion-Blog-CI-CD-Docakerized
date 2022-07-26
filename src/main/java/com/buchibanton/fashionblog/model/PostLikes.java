package com.buchibanton.fashionblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Table(name = "like_table")
public class PostLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;
    private String status;

    @ManyToOne
    private Post post;

    @OneToOne
    private User user1;

}

