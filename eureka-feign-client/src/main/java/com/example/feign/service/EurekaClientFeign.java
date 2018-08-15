package com.example.feign.service;

import com.example.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author：盛年华
 * @Date：2018/8/6 11:40
 * @Description:
 */
@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = HiHystrix.class)
public interface EurekaClientFeign {

    @GetMapping("/hi")
    String sayHiFromClientEureka(@RequestParam("name")String name);
}
