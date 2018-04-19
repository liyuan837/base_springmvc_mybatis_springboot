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
@CacheConfig(cacheNames = "hero")
public interface HeroService {
    List<Hero> queryAll();

    @Cacheable(key="#id")
    Hero findById(Integer id);

//    @CachePut(key="#p0.id")
    Integer saveHero(Hero hero);

//    @CachePut(key="#p0.id")
    Integer updateHero(Hero hero);

    @CacheEvict(key="#id",allEntries = false)
    Integer deleteHero(Integer id);
}
