package com.example.security.service.impl;

import com.example.security.pojo.Blog;
import com.example.security.service.IBlogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author：盛年华
 * @Date：2018/8/16 9:17
 * @Description:
 */
@Service
public class IBlogServiceImpl implements IBlogService {
    private List<Blog> list=new ArrayList<>();

    public IBlogServiceImpl(){
        list.add(new Blog(1L,"spring in action","good!"));
        list.add(new Blog(2L,"spring boot in action","nice!"));
    }

    @Override
    public List<Blog> getBlogs() {

        return list;
    }

    @Override
    public void deleteBlog(long id) {
        Iterator<Blog> iterator=list.iterator();
        while (iterator.hasNext()){
            Blog blog=iterator.next();
            if(blog.getId()==id){
                iterator.remove();
            }
        }
    }
}
