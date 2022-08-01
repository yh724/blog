package com.jklearn.blog.service;

import com.jklearn.blog.domain.Articles;

import java.util.List;

public interface ArticlesService{

    List<Articles> selectArticles(Integer currentPage,Integer pageSize);

    String deleteOneArticle(Integer id);
}
