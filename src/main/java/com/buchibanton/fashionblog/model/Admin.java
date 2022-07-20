package com.buchibanton.fashionblog.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin_table")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;

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

}
