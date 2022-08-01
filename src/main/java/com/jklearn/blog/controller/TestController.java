package com.jklearn.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jklearn.blog.domain.Articles;
import com.jklearn.blog.service.ArticlesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private ArticlesService articlesService;

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello world!";
    }

}
