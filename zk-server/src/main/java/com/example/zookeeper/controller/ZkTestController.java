package com.example.zookeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：盛年华
 * @Date：2018/8/6 10:47
 * @Description:
 */
@RestController
public class ZkTestController {


    @RequestMapping("/hello")
    public String getHello(){
        return "Hello World";
    }

}
