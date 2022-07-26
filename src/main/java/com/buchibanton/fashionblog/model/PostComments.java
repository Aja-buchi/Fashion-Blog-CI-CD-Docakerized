package com.buchibanton.fashionblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Table(name = "post_table")
public class PostComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String message;

    @ManyToOne
    private Post posts;
    @ManyToOne
    private User user1;
}
