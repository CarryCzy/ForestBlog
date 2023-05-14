package com.seiryo.ssm.blog.controller.home;


import com.alibaba.fastjson.JSON;

import com.seiryo.ssm.blog.enums.ArticleStatus;

import com.seiryo.ssm.blog.entity.Article;
import com.seiryo.ssm.blog.entity.Comment;
import com.seiryo.ssm.blog.entity.Tag;
import com.seiryo.ssm.blog.entity.User;
import com.seiryo.ssm.blog.service.*;
import com.seiryo.ssm.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章的controller
 *
 * @author seiryo
 * @date 2017/8/24
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 文章详情页显示
     *
     * @param articleId 文章ID
     * @return modelAndView
     */
    @RequestMapping(value = "/article/{articleId}")
    public String getArticleDetailPage(@PathVariable("articleId") Integer articleId, Model model) {
        //文章信息，分类，标签，作者，评论
        //用户信息
        //文章信息
        //评论列表
        //相关文章
        //猜你喜欢
        //获取下一篇文章
        //获取上一篇文章
        //侧边栏
        //标签列表显示
        //获得随机文章
        //获得热评文章
        return null;
    }

    /**
     * 点赞增加
     *
     * @param id 文章ID
     * @return 点赞量数量
     */
    @RequestMapping(value = "/article/like/{id}", method = {RequestMethod.POST}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String increaseLikeCount(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleLikeCount() + 1;
        article.setArticleLikeCount(articleCount);
        articleService.updateArticle(article);
        return JSON.toJSONString(articleCount);
    }

    /**
     * 文章访问量数增加
     *
     * @param id 文章ID
     * @return 访问量数量
     */
    @RequestMapping(value = "/article/view/{id}", method = {RequestMethod.POST}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String increaseViewCount(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleByStatusAndId(ArticleStatus.PUBLISH.getValue(), id);
        Integer articleCount = article.getArticleViewCount() + 1;
        article.setArticleViewCount(articleCount);
        articleService.updateArticle(article);
        return JSON.toJSONString(articleCount);
    }


}
