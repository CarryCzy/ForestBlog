package com.seiryo.ssm.blog.controller.admin;

import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.seiryo.ssm.blog.dto.ArticleParam;
import com.seiryo.ssm.blog.entity.Article;
import com.seiryo.ssm.blog.service.ArticleService;
import com.seiryo.ssm.blog.service.CategoryService;
import com.seiryo.ssm.blog.service.TagService;

import com.seiryo.ssm.blog.entity.Category;
import com.seiryo.ssm.blog.entity.Tag;
import com.seiryo.ssm.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author seiryo
 */
@Controller
@RequestMapping("/admin/article")
public class BackArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 后台文章列表显示
     *
     * @return modelAndView
     */
    @RequestMapping(value = "")
    public String index(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                        @RequestParam(required = false) String status, Model model) {
        HashMap<String, Object> criteria = new HashMap<>(1);
        if (status == null) {
            model.addAttribute("pageUrlPrefix", "/admin/article?pageIndex");
        } else {
            criteria.put("status", status);
            model.addAttribute("pageUrlPrefix", "/admin/article?status=" + status + "&pageIndex");
        }
        PageInfo<Article> articlePageInfo = articleService.pageArticle(pageIndex, pageSize, criteria);
        model.addAttribute("pageInfo", articlePageInfo);
        return "Admin/Article/index";
    }


    /**
     * 后台添加文章页面显示
     *
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insertArticleView(Model model) {
        //调用categoryService的listCategory获得分类列表
        //调用tagService的listTag获得标签列表
        //model中存入categoryList
        //model中存入tagList
        //跳转至后台管理文章新增页面
        return "";
    }

    /**
     * 后台添加文章提交操作
     *
     * @param articleParam
     * @return
     */
    @RequestMapping(value = "/insertSubmit", method = RequestMethod.POST)
    public String insertArticleSubmit(HttpSession session, ArticleParam articleParam) {
        //实例化文章对象
        //从session中获取用户对象
        //判断用户对象不等于空则放入用户id
            //在文章对象中放入用户id
        //在文章对象中放入页面参数传递过来的文章标题
        //声明文章摘要长度为150
        //通过HtmlUtil工具包调用cleanHtmlTag方法，传入页面参数传递过来的文章内容，清除所有HTML标签返回一个String的字符串
        //判断String字符串的长度是否大于文章摘要的长度
            //如果大于，截取文章内容，从0到文章摘要长度
            //把截取后的内容放入文章对象的文章摘要字段
            //如果小于则直接把转换后的文章内容放入文章对象的摘要字段
        //在文章对象中放入页面传递过来的文章内容
        //在文章对象中放入页面传递过来的文章状态
        //实例化一个类别的集合
        //判断如果页面中传递过来的文章类别如果不等于空
            //在创建的集合中添加一个new出来的类别，new出来的类别传参页面参数传递过来的ArticleParentCategoryId
        //判断如果页面中传递过来的文章类别如果不等于空
            //在创建的集合中添加一个new出来的类别，new出来的类别传参页面参数传递过来的ArticleChildCategoryId
        //在文章对象中放入添加好了类别的集合
        //声明一个标签集合
        //判断如果页面中传递过来的标签集合不等于空
            //遍历标签集合
                //从标签集合中获取出来Tag对象
                //把tag对象取出来放入声明好的标签集合中
        //在文章对象中放入添加好了标签的集合
        //调用articleService的insertArticle方法传入设置好了值的文章对象
        //跳转到后台文章列表显示
        return "";
    }


    /**
     * 删除文章
     *
     * @param id 文章ID
     */
    @RequestMapping(value = "/delete/{id}")
    public void deleteArticle(@PathVariable("id") Integer id) {
        //根据id删除对象
    }


    /**
     * 编辑文章页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editArticleView(@PathVariable("id") Integer id) {
        //实例化ModelAndView对象
        //articleService调用按照文章状态和id显示的方法，状态传入空，id传入获取到的参数得到文章对象
        //把文章对象放入modelAndView对象中
        //categoryService调用类别集合查询方法，返回一个类别集合
        //把类别集合放入modelAndView对象中
        //tagService调用集合查询方法，返回一个标签集合
        //把标签集合放入modelAndView中
        //设置modelAndView跳转到的界面为edit
        //返回modelAndView
        return new ModelAndView();
    }


    /**
     * 编辑文章提交
     *
     * @param articleParam
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editArticleSubmit(ArticleParam articleParam) {
        Article article = new Article();
        article.setArticleId(articleParam.getArticleId());
        article.setArticleTitle(articleParam.getArticleTitle());
        article.setArticleContent(articleParam.getArticleContent());
        article.setArticleStatus(articleParam.getArticleStatus());
        //文章摘要
        int summaryLength = 150;
        String summaryText = HtmlUtil.cleanHtmlTag(article.getArticleContent());
        if (summaryText.length() > summaryLength) {
            String summary = summaryText.substring(0, summaryLength);
            article.setArticleSummary(summary);
        } else {
            article.setArticleSummary(summaryText);
        }
        //填充分类
        List<Category> categoryList = new ArrayList<>();
        if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(new Category(articleParam.getArticleParentCategoryId()));
        }
        if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(new Category(articleParam.getArticleChildCategoryId()));
        }
        article.setCategoryList(categoryList);
        //填充标签
        List<Tag> tagList = new ArrayList<>();
        if (articleParam.getArticleTagIds() != null) {
            for (int i = 0; i < articleParam.getArticleTagIds().size(); i++) {
                Tag tag = new Tag(articleParam.getArticleTagIds().get(i));
                tagList.add(tag);
            }
        }
        article.setTagList(tagList);
        articleService.updateArticleDetail(article);
        return "redirect:/admin/article";
    }


}



