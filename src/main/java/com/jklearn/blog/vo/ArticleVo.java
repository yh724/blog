package com.jklearn.blog.vo;

import com.jklearn.blog.domain.Articles;
import com.jklearn.blog.domain.Labels;
import com.jklearn.blog.domain.Sorts;
import com.jklearn.blog.domain.Users;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ArticleVo {
    private Articles article;
    private Users user;
    private Sorts articleSort;
    private ArrayList<Labels> articleLabels;
}
