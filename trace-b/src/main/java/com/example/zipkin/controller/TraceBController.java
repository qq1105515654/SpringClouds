package com.example.zipkin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author：盛年华
 * @Date：2018/8/10 9:33
 * @Description:
 */
@RestController
public class TraceBController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(){
        return restTemplate.getForObject("http://localhost:8776/info",String.class);
    }

    @RequestMapping("/info")
    public String info(){
        return "trace-B";
    }
}
