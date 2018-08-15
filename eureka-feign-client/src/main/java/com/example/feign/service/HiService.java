package com.example.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：盛年华
 * @Date：2018/8/6 11:43
 * @Description:
 */
@Service
public class HiService {

    @Autowired
    EurekaClientFeign eurekaClientFeign;


    public String sayHi(String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }


}
