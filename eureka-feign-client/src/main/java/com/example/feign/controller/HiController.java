package com.example.feign.controller;

import com.example.feign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：盛年华
 * @Date：2018/8/6 11:44
 * @Description:
 */
@RestController
public class HiController {

    @Autowired
    HiService service;

    @RequestMapping("/hello")
    public String hi(@RequestParam String name){

        return service.sayHi(name);
    }
}
