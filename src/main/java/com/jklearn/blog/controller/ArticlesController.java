package com.jklearn.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.jklearn.blog.domain.Articles;
import com.jklearn.blog.service.ArticlesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    @Resource
    private ArticlesService articlesService;

    @GetMapping("/{currentPage}/{pageSize}")
    public String getArticles(@PathVariable Integer currentPage,
                              @PathVariable Integer pageSize){
        ObjectMapper om = new ObjectMapper();
        String json = "";
        List<Articles> articlesList = articlesService.selectArticles(currentPage,pageSize);
        PageInfo<Articles> pageInfo = new PageInfo<>(articlesList);
        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("total",pageInfo.getTotal());
        resMap.put("articlesList",articlesList);
        try {
            json = om.writeValueAsString(resMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @DeleteMapping("/{id}")
    public String deleteOneArticle(@PathVariable Integer id){
        return articlesService.deleteOneArticle(id);
    }
}
