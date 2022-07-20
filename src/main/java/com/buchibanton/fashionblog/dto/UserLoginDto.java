package com.buchibanton.fashionblog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginDto {
    private String UserName;
    private String email;
    private String password;
}
