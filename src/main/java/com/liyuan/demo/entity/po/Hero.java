package com.liyuan.demo.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 11:20 2018/2/8
 * @Modified By:
 */
public class Hero implements Serializable{
    private static final long serialVersionUID = 3221700752972709820L;

    private Integer id;

    private Integer type;

    private String name;

    private Date createtime;

    private String describe;

    private String skill;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
