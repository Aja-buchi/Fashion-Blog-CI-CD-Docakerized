package com.buchibanton.fashionblog.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter @Getter
public class PostDto {
    private String title;
    private String description;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated = LocalDateTime.now();
    private LocalDateTime deleted = LocalDateTime.now();
}
