package com.seiryo.ssm.blog.controller.home;


import com.github.pagehelper.PageInfo;

import com.seiryo.ssm.blog.enums.ArticleStatus;


import com.seiryo.ssm.blog.entity.Article;
import com.seiryo.ssm.blog.entity.Category;
import com.seiryo.ssm.blog.entity.Tag;
import com.seiryo.ssm.blog.service.ArticleService;
import com.seiryo.ssm.blog.service.CategoryService;
import com.seiryo.ssm.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * 文章分类目录的controller
 *
 * @author seiryo
 * @date 2017/8/24
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    /**
     * 根据分类查询文章
     *
     * @param cateId 分类ID
     * @return 模板
     */
    @RequestMapping("/category/{cateId}")
    public String getArticleListByCategory(@PathVariable("cateId") Integer cateId,
                                           @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                           @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                           Model model) {
        //该分类信息
        //文章列表
        //侧边栏
        //标签列表显示
        //获得随机文章
        //获得热评文章
        return null;
    }


}
