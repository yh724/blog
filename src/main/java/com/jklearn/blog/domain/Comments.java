package com.jklearn.blog.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "comments")
public class Comments {
    /**
     * 评论ID
     */
    @Id
    @Column(name = "comment_id")
    private String commentId;

    /**
     * 发表用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 评论博文ID
     */
    @Column(name = "article_id")
    private String articleId;

    /**
     * 点赞数
     */
    @Column(name = "comment_like_count")
    private Long commentLikeCount;

    /**
     * 评论日期
     */
    @Column(name = "comment_date")
    private String commentDate;

    /**
     * 评论内容
     */
    @Column(name = "comment_content")
    private String commentContent;

    /**
     * 父评论ID
     */
    @Column(name = "parent_comment_id")
    private String parentCommentId;
}