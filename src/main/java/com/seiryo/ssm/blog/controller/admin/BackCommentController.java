package com.seiryo.ssm.blog.controller.admin;


import com.github.pagehelper.PageInfo;
import com.seiryo.ssm.blog.entity.Article;
import com.seiryo.ssm.blog.entity.Comment;
import com.seiryo.ssm.blog.enums.ArticleStatus;
import com.seiryo.ssm.blog.util.MyUtils;
import com.seiryo.ssm.blog.service.ArticleService;
import com.seiryo.ssm.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * @author seiryo
 */
@Controller
@RequestMapping("/admin/comment")
public class BackCommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    /**
     * 评论页面
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return modelAndView
     */
    @RequestMapping(value = "")
    public String commentListView(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                  Model model) {
        //查询所有评论
        return "Admin/Comment/index";
    }


    /**
     * 添加评论
     *
     * @param request
     * @param comment
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public void insertComment(HttpServletRequest request, Comment comment) {
        //添加评论
        //更新文章的评论数
    }

    /**
     * 删除评论
     *
     * @param id 批量ID
     */
    @RequestMapping(value = "/delete/{id}")
    public void deleteComment(@PathVariable("id") Integer id) {
        //删除评论
        //删除其子评论
        //更新文章的评论数
    }

    /**
     * 编辑评论页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public String editCommentView(@PathVariable("id") Integer id, Model model) {
        //跳转编辑评论界面
        return "Admin/Comment/edit";
    }


    /**
     * 编辑评论提交
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editCommentSubmit(Comment comment) {
        //编辑评论提交
        return "redirect:/admin/comment";
    }


    /**
     * 回复评论页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/reply/{id}")
    public String replyCommentView(@PathVariable("id") Integer id, Model model) {
        //回复评论
        return "Admin/Comment/reply";
    }

    /**
     * 回复评论提交
     *
     * @param request
     * @param comment
     * @return
     */
    @RequestMapping(value = "/replySubmit", method = RequestMethod.POST)
    public String replyCommentSubmit(HttpServletRequest request, Comment comment) {
        //文章评论数+1
        //添加评论
        return "redirect:/admin/comment";
    }

}
