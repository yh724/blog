package com.jklearn.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.jklearn.blog.domain.Articles;
import com.jklearn.blog.domain.SetArtitleLabel;
import com.jklearn.blog.domain.SetArtitleSort;
import com.jklearn.blog.mapper.ArticlesMapper;
import com.jklearn.blog.mapper.SetArtitleLabelMapper;
import com.jklearn.blog.mapper.SetArtitleSortMapper;
import com.jklearn.blog.service.ArticlesService;
import com.jklearn.blog.utils.DateTimeUtil;
import com.jklearn.blog.utils.UUIDUtil;
import com.jklearn.blog.vo.ResponseVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticlesServiceImpl implements ArticlesService {

    @Resource
    private ArticlesMapper articlesMapper;

    @Resource
    private SetArtitleSortMapper setArtitleSortMapper;

    @Resource
    private SetArtitleLabelMapper setArtitleLabelMapper;

    @Override
    public List<Articles> selectArticles(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return articlesMapper.selectAll();
    }

    @Override
    public String deleteOneArticle(String id) {
        String message = "error";
        int res1 = articlesMapper.deleteByPrimaryKey(id);
        int res2 = setArtitleSortMapper.deleteByPrimaryKey(id);
        int res3 = setArtitleLabelMapper.removeAllByArticleKey(id);
        if (res1 == 1 && res2==1 && res3 >= 1) {
            message = "success";
        }
        return message;
    }

    @Override
    public String insertArticle(ResponseVo vo) {
        String message = "error";
        Articles articles = new Articles();
        articles.setArticleId(UUIDUtil.getUUID());
        articles.setUserId(vo.getUserId());
        articles.setArticleTitle(vo.getArticleTitle());
        articles.setArticleContent(vo.getArticleContent());
        articles.setArticleDate(DateTimeUtil.getSysTime());
        articles.setArticleViews(0L);
        articles.setArticleCommentCount(0L);
        articles.setArticleLikeCount(0L);
        int res1 = articlesMapper.insertSelective(articles);
        int res2 = setArtitleSortMapper.insert(new SetArtitleSort(articles.getArticleId(), vo.getArticleSortId()));
        for (String id : vo.getArticleLabelIds()) {
            int res3 = setArtitleLabelMapper.insert(new SetArtitleLabel(articles.getArticleId(), id));
            if (res3 != 1)
                return "error";
        }
        if (res1 == 1 && res2 == 1) {
            message = "success";
        }
        return message;
    }

    @Override
    public String updateArticle(ResponseVo vo) {
        String message = "error";
        Articles articles = new Articles();
        articles.setArticleId(vo.getArticleId());
        articles.setArticleTitle(vo.getArticleTitle());
        articles.setArticleContent(vo.getArticleContent());
        int res1 = articlesMapper.updateByPrimaryKeySelective(articles);
        setArtitleSortMapper.insertOrUpdate(vo.getArticleId(),vo.getArticleSortId());
        setArtitleLabelMapper.removeAllByArticleKey(vo.getArticleId());
        for (String id :
                vo.getArticleLabelIds()) {
            setArtitleLabelMapper.insert(new SetArtitleLabel(vo.getArticleId(),id));
        }
        if (res1 == 1) {
            message = "success";
        }
        return message;
    }

    @Override
    public List<Articles> selectAll() {
        return articlesMapper.selectAll();
    }
}
