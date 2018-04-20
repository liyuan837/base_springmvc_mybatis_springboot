package com.liyuan.demo.controller;

import com.liyuan.demo.controller.base.BaseController;
import com.liyuan.demo.entity.exception.DemoException;
import com.liyuan.demo.entity.po.Hero;
import com.liyuan.demo.entity.response.ResponseEntity;
import com.liyuan.demo.service.HeroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 15:28 2018/2/8
 * @Modified By:
 */
@RestController
@RequestMapping("/hero")
@Api(value="/hero",description = "英雄泪")
public class HeroController extends BaseController{

    @Autowired
    private HeroService heroService;


    @ApiOperation(value="获取英雄列表", notes="获取所有英雄的信息列表")
    @GetMapping("/get")
    public ResponseEntity list() throws DemoException{
        List<Hero> list = heroService.queryAll();
        if(list == null || list.size()<=0){
            return null;
        }
        return getSuccessResult(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity find(@PathVariable("id") Integer id) throws DemoException{
        Hero hero = heroService.findById(id);
        if(hero == null){
            return getFailResult("该英雄不存在！");
        }
        return getSuccessResult(hero);

    }

    @ApiOperation(value="创建英雄", notes="根据Hero对象创建新英雄")
    @ApiImplicitParam(name = "hero", value = "英雄详细实体hero", required = true, dataType = "Hero")
    @PostMapping("/post")
    public Map<String,Object> post(@RequestBody Hero hero) throws DemoException{
        Map<String,Object> modelMap = new HashMap<>();
        Hero result = heroService.saveHero(hero);
        modelMap.put("hero",result);
        return modelMap;
    }

    @PostMapping("/put")
    public Map<String,Object> put(@RequestBody Hero hero) throws DemoException{
        Map<String,Object> modelMap = new HashMap<>();
        Hero result = heroService.updateHero(hero);
        modelMap.put("hero",result);
        return modelMap;
    }
    @GetMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") Integer id) throws DemoException{
        Map<String,Object> modelMap = new HashMap<>();
        Integer result = heroService.deleteHero(id);
        modelMap.put("result","deleteSuccess");
        return modelMap;

    }
}
