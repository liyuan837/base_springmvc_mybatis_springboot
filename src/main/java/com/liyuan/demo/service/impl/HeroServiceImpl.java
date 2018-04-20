package com.liyuan.demo.service.impl;

import com.liyuan.demo.dao.HeroDao;
import com.liyuan.demo.entity.Hero;
import com.liyuan.demo.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 15:13 2018/2/8
 * @Modified By:
 */
@Service
@CacheConfig(cacheNames = "hero")
public class HeroServiceImpl implements HeroService{
    @Autowired
    private HeroDao heroDao;

    @Override
    public List<Hero> queryAll() {
        return heroDao.queryAll();
    }

    @Override
    @Cacheable(key = "#id")
    public Hero findById(Integer id) {
        return heroDao.findById(id);
    }

    @Transactional
    @Override
//    @CachePut(key="#p0.id")
    public Hero saveHero(Hero hero) {
        if(hero.getName() != null && !"".equals(hero.getName().trim())){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                hero.setCreatetime(sdf.parse(sdf.format(new Date())));
                Integer result = heroDao.saveHero(hero);
                if(result > 0){
                    hero.setId(result);
                    return hero;
                }else{
                    throw new RuntimeException("插入失败");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else{
            throw new RuntimeException("信息不完整");
        }
        return null;
    }

    @Transactional
    @Override
    @CachePut(key = "#p0.id")
    public Hero updateHero(Hero hero) {
        Integer result = heroDao.updateHero(hero);

        return result>0?hero:null;
    }

    @Transactional
    @Override
    @CachePut(key="#p0.id")
    public Integer deleteHero(Integer id) {
        return heroDao.deleteHero(id);
    }
}
