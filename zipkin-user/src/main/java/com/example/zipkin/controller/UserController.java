package com.example.zipkin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：盛年华
 * @Date：2018/8/13 9:13
 * @Description:
 */
@RestController
public class UserController {


    @RequestMapping("/hi")
    public String hi(){
        return "I'm forezp";
    }
}
