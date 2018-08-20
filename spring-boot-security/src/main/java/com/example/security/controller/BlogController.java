package com.example.security.controller;

import com.example.security.pojo.Blog;
import com.example.security.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author：盛年华
 * @Date：2018/8/16 9:23
 * @Description:
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping
    public ModelAndView list(Model model){
        List<Blog> list=blogService.getBlogs();
        model.addAttribute("blogsList",list);
        return new ModelAndView("blogs/list","blogModel",model);
    }
    /*
    *  PreAuthorize 注解，表示在方法执行之前，先进行角色 判断。如果是 ROLE_ADMIN 允许执行此方法。
    *
    * */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/deletion")
    public ModelAndView delete(@PathVariable long id,Model model){
        blogService.deleteBlog(id);
        model.addAttribute("blogsList",blogService.getBlogs());
        return new ModelAndView("blogs/list","blogModel",model);
    }
}
