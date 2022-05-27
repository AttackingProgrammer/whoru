package com.ydp.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test
 * @Author ydp
 * @Version
 * @Date 2021/7/6
 */
@RestController
@RequestMapping("/breaker")
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("/fallback")
    public Map<String, Object> handle() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 50001);
        map.put("msg", "服务繁忙");
        return map;
    }



}