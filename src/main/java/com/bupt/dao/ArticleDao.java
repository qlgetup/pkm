package com.bupt.dao;

import com.bupt.model.Article;
import com.bupt.model.Userarticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {
    List<Article> catalog(int uid);
    int newarticle(Article file);
    int deletearticle(Article file);
    int updatearticle(Article file);
    List<Userarticle> artcom();
    List<Userarticle> search1(@Param("username") String username);
    List<Userarticle> search2(@Param("name") String name);
}
