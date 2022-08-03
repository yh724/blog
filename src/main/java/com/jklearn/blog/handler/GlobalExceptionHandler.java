package com.jklearn.blog.handler;

import com.jklearn.blog.exception.BlogException;
import com.jklearn.blog.vo.CommonReturnType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogException.class)
    public <T> CommonReturnType<T> handler(BlogException be){
        return CommonReturnType.fail(be.getBlogEnum());
    }
}
