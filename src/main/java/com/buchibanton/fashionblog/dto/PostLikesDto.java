package com.buchibanton.fashionblog.dto;

import com.buchibanton.fashionblog.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Data @Setter @Getter
public class PostLikesDto {

    private boolean status;

    @ManyToOne
    private User user1;
}
