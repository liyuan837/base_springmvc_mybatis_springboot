package com.liyuan.demo.service;

import com.liyuan.demo.entity.Hero;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
