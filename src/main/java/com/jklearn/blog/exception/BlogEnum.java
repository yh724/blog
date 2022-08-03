package com.jklearn.blog.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BlogEnum {

    GLOBAL_SUCCESS("200","操作成功！"),
    GLOBAL_ERROR("400","操作失败！"),

    SORT_INSERT("003-001", "添加分类失败！"),
    SORT_UPDATE("003-002", "修改分类失败"),
    SORT_DELETE("003-003", "删除分类失败！"),

    LABEL_INSERT_ERROR("004-001","添加标签失败！"),
    LABEL_UPDATE_ERROR("004-002","修改标签失败！"),
    LABEL_DELETE_ERROR("004-003","删除标签失败！");

    private String typeCode;
    private String message;

    BlogEnum(String typeCode, String message) {
        this.typeCode = typeCode;
        this.message = message;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
