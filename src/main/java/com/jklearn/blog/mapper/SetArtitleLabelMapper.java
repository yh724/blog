package com.jklearn.blog.mapper;

import com.jklearn.blog.domain.SetArtitleLabel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SetArtitleLabelMapper extends Mapper<SetArtitleLabel> {

    @Select("select * from set_artitle_label where article_id=#{articleId}")
    List<SetArtitleLabel> selectWithArticleId(String articleId);

    @Delete("delete from set_artitle_label where article_id=#{articleId}")
    int removeAllByArticleKey(String articleId);

    @Delete("delete from set_artitle_label where label_id=#{id} ")
    int removeAllByLabelKey(String id);
}