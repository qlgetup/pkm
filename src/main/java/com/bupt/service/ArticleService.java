package com.bupt.service;

import com.bupt.model.Article;
import com.bupt.model.Userarticle;

import java.util.List;

public interface ArticleService {
    List<Article> catalog(int uid);
    Article newarticle(Article file);
    int deletearticle(Article file);
    Article updatearticle(Article file);
    List<Userarticle> artcom();
    List<Userarticle> search(String way,String searchcon);
}
