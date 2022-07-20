package com.buchibanton.fashionblog.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter @Getter
public class UserSignUpDto {
    private String firstName;
    private String lastName;
    private String UserName;
    private String email;
    private String password;
}
