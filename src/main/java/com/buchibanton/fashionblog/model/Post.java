package com.buchibanton.fashionblog.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;

    private String title;
    private String description;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated = LocalDateTime.now();
    private LocalDateTime deleted = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private Admin admin1;

    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private User user1;
}
