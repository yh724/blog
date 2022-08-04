package com.jklearn.blog.service;

import com.jklearn.blog.domain.Articles;
import com.jklearn.blog.vo.ResponseVo;

import java.util.List;

public interface ArticlesService{

    List<Articles> selectArticles(Integer currentPage,Integer pageSize);

    String deleteOneArticle(String id);

    String insertArticle(ResponseVo vo);

    String updateArticle(ResponseVo vo);
}
