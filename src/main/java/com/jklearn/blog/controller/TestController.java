package com.jklearn.blog.controller;

import cn.dev33.satoken.stp.StpUtil;
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

    @RequestMapping("/user/login")
    public String doLogin(String username,String password){
        if("zhangsan".equals(username) && "123456".equals(password)){
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    @RequestMapping("/user/isLogin")
    public String isLogin(){
        return "当前会话是否登录："+StpUtil.isLogin()+",token："+StpUtil.getTokenInfo();
    }

}
