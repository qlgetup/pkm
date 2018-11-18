package com.bupt.service;

import com.bupt.dao.ArticleDao;
import com.bupt.model.Article;
import com.bupt.model.Userarticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    public List<Article> catalog(int uid){
        return articleDao.catalog(uid);
    }

    @Override
    public Article newarticle(Article article) {
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        article.setTime(dateString);
        articleDao.newarticle(article);
        return article;
    }

    @Override
    public int deletearticle(Article article) {
        return articleDao.deletearticle(article);
    }


    @Override
    public Article updatearticle(Article article) {
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        article.setTime(dateString);
        articleDao.updatearticle(article);
        return article;
    }

    @Override
    public List<Userarticle> artcom() {
        return articleDao.artcom();
    }

    @Override
    public List<Userarticle> search(String way,String searchcon) {
        if(way.equals("1")) return articleDao.search1(searchcon);
        else  return articleDao.search2("%"+searchcon+"%");
    }

}
