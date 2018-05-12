package com.liyuan.demo.entity.po;

import lombok.Data;

/**
 * @Author:LiYuan
 * @description:
 * @Date:Create in 10:21 2018/5/12
 * @Modified By:
 */
@Data
public class JwtUser {
    private Integer id;
    private String username;
    private String usercode;
    private String password;
}
