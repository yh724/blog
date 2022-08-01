package com.jklearn.blog.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "articles")
public class Articles {
    /**
     * 博文ID
     */
    @Id
    @Column(name = "article_id")
    private String articleId;

    /**
     * 发表用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 博文标题
     */
    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 博文内容
     */
    @Column(name = "article_content")
    private String articleContent;

    /**
     * 浏览量
     */
    @Column(name = "article_views")
    private Long articleViews;

    /**
     * 评论总数
     */
    @Column(name = "article_comment_count")
    private Long articleCommentCount;

    /**
     * 发表时间
     */
    @Column(name = "article_date")
    private String articleDate;

    @Column(name = "article_like_count")
    private Long articleLikeCount;
}