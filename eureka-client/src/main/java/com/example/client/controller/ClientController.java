package com.example.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：盛年华
 * @Date：2018/8/6 11:18
 * @Description:
 */
@RestController
public class ClientController {

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return "Hello："+name;
    }
}
