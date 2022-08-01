package com.jklearn.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.jklearn.blog.domain.Articles;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jklearn.blog.mapper.ArticlesMapper;
import com.jklearn.blog.service.ArticlesService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService{

    @Resource
    private ArticlesMapper articlesMapper;

    @Override
    public List<Articles> selectArticles(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        return articlesMapper.selectAll();
    }

    @Override
    public String deleteOneArticle(Integer id) {
        String message="error";
        int res = articlesMapper.deleteByPrimaryKey(id);
        if(res == 1 ){
            message = "success";
        }
        return message;
    }
}
