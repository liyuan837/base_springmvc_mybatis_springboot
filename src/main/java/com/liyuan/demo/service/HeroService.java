package com.liyuan.demo.service;

import com.liyuan.demo.entity.po.Hero;

import java.util.List;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 11:24 2018/2/8
 * @Modified By:
 */
public interface HeroService {

    List<Hero> queryAll();

    Hero findById(Integer id);


    Hero saveHero(Hero hero);


    Hero updateHero(Hero hero);


    Integer deleteHero(Integer id);
}
