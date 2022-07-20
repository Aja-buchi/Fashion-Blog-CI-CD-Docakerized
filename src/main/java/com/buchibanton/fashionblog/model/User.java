package com.buchibanton.fashionblog.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Size(min = 3, max = 10, message = "Username must be between 3 to 10 characters")
    private String firstName;

    @Size(min = 3, max = 10, message = "Username must be between 3 to 10 characters")
    private String lastName;

    @Size(min = 3, max = 10, message = "Username must be between 3 to 10 characters")
    private String userName;

    @NotNull
    @Column(unique = true, nullable = false, name = "email_address")
    private String email;

    @Size(min = 5, max = 15, message = "Password must be between 5 to 15 characters")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "postId"
    )
    private List<Post> post;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "comment_id",
            referencedColumnName = "commentId"
    )
    private List<PostComments> postComments;
}
