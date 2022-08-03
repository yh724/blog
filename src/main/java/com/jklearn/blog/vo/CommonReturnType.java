package com.jklearn.blog.vo;

import com.jklearn.blog.exception.BlogEnum;
import lombok.Data;

@Data
public class CommonReturnType<T> {
    private BlogEnum message;
    private T data;
    public static <T> CommonReturnType<T> success(T data){
        CommonReturnType<T> result = new CommonReturnType<>();
        result.setMessage(BlogEnum.GLOBAL_SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> CommonReturnType<T> fail(BlogEnum blogEnum){
        CommonReturnType<T> result = new CommonReturnType<>();
        result.setData(null);
        result.setMessage(blogEnum);
        return result;
    }
}
