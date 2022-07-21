package com.buchibanton.fashionblog.model.pageCriterias;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Setter @Getter

//Implementation of Pagination
public class PostPage {
    private int pageNumber = 0;
    private int pageSize = 5;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "title";
}
