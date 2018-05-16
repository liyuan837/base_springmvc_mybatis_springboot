package com.liyuan.demo.controller;

import com.liyuan.demo.annotation.NotToken;
import com.liyuan.demo.entity.po.JwtUser;
import com.liyuan.demo.service.RedisService;
import com.liyuan.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private RedisService redisService ;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public void demoTest(){
        redisService.set("1","value22222");
    }

    //模拟登陆成功，返回token
//    @NotToken
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(){
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername("李袁");
        jwtUser.setUsercode("A0001");

        return JwtUtil.generateToken(jwtUser);
    }

}