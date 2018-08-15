package com.example.feign.service;

import org.springframework.stereotype.Component;

/**
 * @Author：盛年华
 * @Date：2018/8/6 14:06
 * @Description:
 */
@Component
public class HiHystrix implements EurekaClientFeign {

    @Override
    public String sayHiFromClientEureka(String name) {
        return "hi,"+name+", sorry,error!";
    }
}
