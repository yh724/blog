package com.jklearn.blog.mapper;

import com.jklearn.blog.domain.SetArtitleSort;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.common.Mapper;

public interface SetArtitleSortMapper extends Mapper<SetArtitleSort> {
    @Delete("delete from set_artitle_sort where sort_id=#{id} ;")
    void removeAllBySortKey(String id);

    @Insert("insert into set_artitle_sort (article_id, sort_id)" +
            " values (#{articleId}, #{articleSortId})" +
            " on duplicate key update sort_id=#{articleSortId};")
    void insertOrUpdate(String articleId, String articleSortId);
}