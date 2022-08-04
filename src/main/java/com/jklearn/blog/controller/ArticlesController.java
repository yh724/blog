package com.jklearn.blog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.jklearn.blog.domain.*;
import com.jklearn.blog.service.*;
import com.jklearn.blog.vo.ArticleVo;
import com.jklearn.blog.vo.ResponseVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    @Resource
    private ArticlesService articlesService;

    @Resource
    private SetArtitleSortService setArtitleSortService;

    @Resource
    private SetArtitleLabelService setArtitleLabelService;

    @Resource
    private LabelsService labelsService;

    @Resource
    private SortsService sortsService;

    @Resource
    private UsersService usersService;

    @GetMapping("/{currentPage}/{pageSize}")
    public String getArticles(@PathVariable Integer currentPage,
                              @PathVariable Integer pageSize){
        ObjectMapper om = new ObjectMapper();
        String json = "";
        List<Articles> articlesList = articlesService.selectArticles(currentPage,pageSize);

        List<ArticleVo> articleVoList = new ArrayList<>();
        SetArtitleSort articleSort = new SetArtitleSort();
        for (Articles article : articlesList) {
            ArticleVo avo = new ArticleVo();
            articleSort  = setArtitleSortService.queryById(article.getArticleId());
            List<SetArtitleLabel> articleLabelList = setArtitleLabelService.queryById(article.getArticleId());
            ArrayList<Labels> articleLabels = new ArrayList<>();
            Sorts s = new Sorts();
            Users u = new Users();
            for (SetArtitleLabel label:
                 articleLabelList) {
                Labels l = labelsService.selectLabelById(label.getLabelId());
                articleLabels.add(l);
            }
            if (articleSort != null) {
                s = sortsService.selectSortById(articleSort.getSortId());
            }
            u = usersService.selectUserById(article.getUserId());
            avo.setArticle(article);
            avo.setArticleLabels(articleLabels);
            avo.setArticleSort(s);
            avo.setUser(u);
            articleVoList.add(avo);
        }
        PageInfo<Articles> pageInfo = new PageInfo<>(articlesList);
        HashMap<String,Object> resMap = new HashMap<>();
        resMap.put("total",pageInfo.getTotal());
        resMap.put("articlesList",articleVoList);
        try {
            json = om.writeValueAsString(resMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @PostMapping
    public String saveArticle(@RequestBody ResponseVo vo){
        return articlesService.insertArticle(vo);
    }

    @PutMapping
    public String updateArticle(@RequestBody ResponseVo rvo){
        return articlesService.updateArticle(rvo);
    }

    @DeleteMapping("/{id}")
    public String deleteOneArticle(@PathVariable String id){
        return articlesService.deleteOneArticle(id);
    }
}
