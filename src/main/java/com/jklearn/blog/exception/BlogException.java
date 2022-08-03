package com.jklearn.blog.exception;

public class BlogException extends RuntimeException{

    private BlogEnum blogEnum;

    public BlogException(BlogEnum blogEnum) {
        super(blogEnum.getMessage());
        this.blogEnum = blogEnum;
    }

    public void setBlogEnum(BlogEnum blogEnum) {
        this.blogEnum = blogEnum;
    }

    public BlogEnum getBlogEnum() {
        return blogEnum;
    }
}
