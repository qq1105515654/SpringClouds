package com.example.security.service;

import com.example.security.pojo.Blog;

import java.util.List;

/**
 * @Author：盛年华
 * @Date：2018/8/16 9:16
 * @Description:
 */
public interface IBlogService {

    List<Blog> getBlogs();

    void deleteBlog(long id);

}
