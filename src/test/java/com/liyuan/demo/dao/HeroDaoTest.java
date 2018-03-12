package com.liyuan.demo.dao;

import com.liyuan.demo.entity.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 14:18 2018/2/8
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroDaoTest {
    @Autowired
    private HeroDao heroDao;

    @Test
    public void queryAll() throws Exception {
        List<Hero> heroList = heroDao.queryAll();
        assertEquals(1,heroList.size());
    }

    @Test
    public void findById() throws Exception {
        Hero hero = heroDao.findById(1);
        assertEquals("王昭君",hero.getName());
    }

    @Test
    public void saveHero() throws Exception {
        Hero hero = new Hero();
        hero.setName("甄姬");
        hero.setType(1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hero.setCreatetime(sdf.parse(sdf.format(date)));
        hero.setSkill("凝泪成冰，泪如泉涌，叹息水流，洛神降临");
        hero.setDescribe("甄姬是《王者荣耀》中一位性价比很高的法师英雄。甄姬擅长使用水来控制和伤害敌人，可以说具有强大的团控和控制能力，况且本身的输出也很高，可以用2技能打出多段伤害，不要试图追杀敌方残血，要在后排尽最大可能控制敌人，协助队友完成击杀。甄姬在游戏中以成熟御姐的形象出现，有着不俗的攻击伤害和技能效果，而且团控能力也十分出色，能很好的配合队友对敌人造成毁灭性的的打击。往往逆风局中，甄姬的大招配合被动可以让敌人全部被冰冻，从而完成Carry。");
        Integer result = heroDao.saveHero(hero);
        System.out.println(hero.getId());
    }

    @Test
    public void updateHero() throws Exception {
        Hero hero = new Hero();
        hero.setId(5);
        hero.setName("甄姬1");
        Integer result = heroDao.updateHero(hero);
        System.out.println(result);
    }

    @Test
    public void deleteHero() throws Exception {
        Integer result = heroDao.deleteHero(5);
    }

}