package com.liyuan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 11:03 2018/2/8
 * @Modified By:
 */
@ApiIgnore
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
