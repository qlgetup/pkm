package com.bupt.controller;

import com.bupt.model.Article;
import com.bupt.model.Userarticle;
import com.bupt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleServiceImple;
    @CrossOrigin
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public List<Article> gencata(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("id");
        return articleServiceImple.catalog(uid);
    }

    @CrossOrigin
    @RequestMapping(value = "/newarticle", method = RequestMethod.POST)
    public Article newarticle(@RequestBody Article article, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int uid=(int) session.getAttribute("id");
        article.setUid(uid);
        return  articleServiceImple.newarticle(article);
    }

    @CrossOrigin
    @RequestMapping(value = "/deletearticle", method = RequestMethod.POST)
    public int deletearticle(@RequestBody Article article) {
        return articleServiceImple.deletearticle(article);
    }

    @CrossOrigin
    @RequestMapping(value = "/updatearticle", method = RequestMethod.POST)
    public Article updatearticle(@RequestBody Article article) {
        return articleServiceImple.updatearticle(article);
    }


    @CrossOrigin
    @RequestMapping(value = "/article-recommend", method = RequestMethod.POST)
    public List<Userarticle> artcom() {
        return articleServiceImple.artcom();
    }

    @CrossOrigin
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Userarticle> search(@RequestParam("way")String way,@RequestParam("search-con")String searchcon) {
        return articleServiceImple.search(way,searchcon);
    }
}
