package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ozan
 * @Description: 测试本项目是否存活
 * @Date: Created in 10:30 2018/5/3.
 * @Modified By:
 */

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "active";
    }
}
